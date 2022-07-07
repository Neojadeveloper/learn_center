package neo.setup.learn_center.service.auth.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import neo.setup.learn_center.criteria.auth.token.AuthTokenCriteria;
import neo.setup.learn_center.dto.auth.token.AuthTokenCreateDTO;
import neo.setup.learn_center.dto.auth.token.AuthTokenDetailDTO;
import neo.setup.learn_center.dto.auth.token.AuthTokenGetDTO;
import neo.setup.learn_center.dto.auth.token.AuthTokenUpdateDTO;
import neo.setup.learn_center.entity.auth.token.AuthToken;
import neo.setup.learn_center.entity.auth.user.AuthUser;
import neo.setup.learn_center.enums.auth.token_type.AuthTokenTypeEnum;
import neo.setup.learn_center.exception.exception.NotFoundException;
import neo.setup.learn_center.mapper.auth.token.AuthTokenMapper;
import neo.setup.learn_center.repository.auth.token.AuthTokenRepository;
import neo.setup.learn_center.repository.auth.user.AuthUserRepository;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.AbstractService;
import neo.setup.learn_center.utils.jwt.JWTUtils;
import neo.setup.learn_center.validator.auth.token.AuthTokenValidator;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.*;

@Service
@Transactional
public class AuthTokenServiceImpl extends AbstractService<AuthTokenValidator, AuthTokenMapper, AuthTokenRepository> implements AuthTokenService {
    private final AuthUserRepository authUserRepository;

    public AuthTokenServiceImpl(AuthTokenValidator validator, AuthTokenMapper mapper, AuthTokenRepository repository, AuthUserRepository authUserRepository) {
        super(validator, mapper, repository);
        this.authUserRepository = authUserRepository;
    }

    @Override
    public ResponseEntity<Data<Void>> create(AuthTokenCreateDTO DTO) {
        validator.validOnCreate(DTO);
        repository.save(mapper.toCreateDTO(DTO));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Data<Void>> update(AuthTokenUpdateDTO DTO) {
        return null;
    }

    @Override
    public ResponseEntity<Data<Void>> delete(UUID key) {
        validator.validateKey(key);
        Optional<AuthToken> optional = repository.getByCode(key);
        if (optional.isEmpty()) {
            throw new NotFoundException("Token not found");
        }
        repository.deleteByCode(key);
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<AuthTokenGetDTO>> get(UUID key) {
        validator.validateKey(key);
        return new ResponseEntity<>(new Data<>(mapper.fromGetDTO(repository.getByCode(key).orElseThrow(() -> new NotFoundException("Token not found")))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<AuthTokenDetailDTO>> detail(UUID key) {
        validator.validateKey(key);
        return new ResponseEntity<>(new Data<>(mapper.fromDetailDTO(repository.getByCode(key).orElseThrow(() -> new NotFoundException("Token not found")))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<AuthTokenGetDTO>>> list(AuthTokenCriteria criteria) {
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize());
        return new ResponseEntity<>(new Data<>(mapper.fromGetListDTO(repository.findAll(request).stream().toList()), repository.count()), HttpStatus.OK);
    }

    @Override
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            try {
                String refreshToken = authorizationHeader.substring("Bearer ".length());
                DecodedJWT jwt = JWTUtils.getVerifier().verify(refreshToken);
                String userCode = jwt.getSubject();
                AuthUser user = authUserRepository.findByCode(UUID.fromString(userCode));
                Date accessDate = JWTUtils.getExpiry();

                String accessToken = JWT.create().withSubject(user.getCode().toString()).withExpiresAt(accessDate).withIssuer(request.getRequestURL().toString()).withClaim("roles", authUserRepository.getRolesByCode(UUID.fromString(userCode))).sign(JWTUtils.getAlgorithm());

                AuthTokenCreateDTO tokenCreateDTO = new AuthTokenCreateDTO(UUID.fromString(userCode), accessToken, accessDate, AuthTokenTypeEnum.ACCESS_TOKEN.name());
                create(tokenCreateDTO);

                AuthTokenGetDTO tokenGetDTO1 = new AuthTokenGetDTO(AuthTokenTypeEnum.ACCESS_TOKEN.name(), accessToken);
                AuthTokenGetDTO tokenGetDTO2 = new AuthTokenGetDTO(AuthTokenTypeEnum.REFRESH_TOKEN.name(), refreshToken);
                List<AuthTokenGetDTO> tokenGetDTOList = new ArrayList<>();
                tokenGetDTOList.add(tokenGetDTO1);
                tokenGetDTOList.add(tokenGetDTO2);

                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokenGetDTOList);
            } catch (Exception e) {
                response.setHeader("error", e.getMessage());
                response.setStatus(HttpStatus.FORBIDDEN.value());
                Map<String, String> error = new HashMap<>();
                error.put("error_message", e.getMessage());
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }
        } else {
            throw new RuntimeException("Refresh token is missing");
        }
    }
}
