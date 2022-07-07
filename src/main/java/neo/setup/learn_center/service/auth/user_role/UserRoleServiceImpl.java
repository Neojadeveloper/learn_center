package neo.setup.learn_center.service.auth.user_role;

import neo.setup.learn_center.criteria.auth.user_role.UserRoleCriteria;
import neo.setup.learn_center.dto.auth.user_role.UserRoleCreateDTO;
import neo.setup.learn_center.dto.auth.user_role.UserRoleDetailDTO;
import neo.setup.learn_center.dto.auth.user_role.UserRoleGetDTO;
import neo.setup.learn_center.dto.auth.user_role.UserRoleUpdateDTO;
import neo.setup.learn_center.entity.auth.user_role.AuthUserRole;
import neo.setup.learn_center.exception.exception.NotFoundException;
import neo.setup.learn_center.mapper.auth.user_role.UserRoleMapper;
import neo.setup.learn_center.repository.auth.user_role.UserRoleRepository;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.AbstractService;
import neo.setup.learn_center.validator.auth.user_role.UserRoleValidator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserRoleServiceImpl extends AbstractService<UserRoleValidator, UserRoleMapper, UserRoleRepository> implements UserRoleService {
    public UserRoleServiceImpl(UserRoleValidator validator, UserRoleMapper mapper, UserRoleRepository repository) {
        super(validator, mapper, repository);
    }

    @Override
    public ResponseEntity<Data<Void>> create(UserRoleCreateDTO DTO) {
        validator.validOnCreate(DTO);
        repository.save(mapper.toCreateDTO(DTO));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Void>> update(UserRoleUpdateDTO DTO) {
        return null;
    }

    @Override
    public ResponseEntity<Data<Void>> delete(UUID key) {
        validator.validateKey(key);
        Optional<AuthUserRole> optional = repository.getByCode(key);
        if (optional.isEmpty()) {
            throw new NotFoundException("Auth User Role not found");
        }
        repository.deleteByCode(key);
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<UserRoleGetDTO>> get(UUID key) {
        validator.validateKey(key);
        return new ResponseEntity<>(new Data<>(mapper.fromGetDTO(repository.getByCode(key).orElseThrow(() -> new NotFoundException("Auth User Role not found")))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<UserRoleDetailDTO>> detail(UUID key) {
        validator.validateKey(key);
        return new ResponseEntity<>(new Data<>(mapper.fromDetailDTO(repository.getByCode(key).orElseThrow(() -> new NotFoundException("Auth User Role not found")))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<UserRoleGetDTO>>> list(UserRoleCriteria criteria) {
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize());
        Page<AuthUserRole> all = repository.findAll(request);
        return new ResponseEntity<>(new Data<>(mapper.fromGetListDTO(all.toList()), all.getSize()), HttpStatus.OK);
    }
}
