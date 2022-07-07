package neo.setup.learn_center.mapper.auth.user;

import neo.setup.learn_center.dto.auth.user.AuthUserCreateDTO;
import neo.setup.learn_center.dto.auth.user.AuthUserDetailDTO;
import neo.setup.learn_center.dto.auth.user.AuthUserGetDTO;
import neo.setup.learn_center.dto.auth.user.AuthUserUpdateDTO;
import neo.setup.learn_center.entity.auth.user.AuthUser;
import neo.setup.learn_center.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AuthUserMapper extends GenericMapper<AuthUserCreateDTO, AuthUserUpdateDTO, AuthUserGetDTO, AuthUserDetailDTO, AuthUser> {
}
