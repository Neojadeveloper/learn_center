package neo.setup.learn_center.mapper.auth.token;

import neo.setup.learn_center.dto.auth.token.AuthTokenCreateDTO;
import neo.setup.learn_center.dto.auth.token.AuthTokenDetailDTO;
import neo.setup.learn_center.dto.auth.token.AuthTokenGetDTO;
import neo.setup.learn_center.dto.auth.token.AuthTokenUpdateDTO;
import neo.setup.learn_center.entity.auth.token.AuthToken;
import neo.setup.learn_center.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AuthTokenMapper extends GenericMapper<AuthTokenCreateDTO, AuthTokenUpdateDTO, AuthTokenGetDTO, AuthTokenDetailDTO, AuthToken> {
}
