package neo.setup.learn_center.mapper.auth.user_role;

import neo.setup.learn_center.dto.auth.user_role.UserRoleCreateDTO;
import neo.setup.learn_center.dto.auth.user_role.UserRoleDetailDTO;
import neo.setup.learn_center.dto.auth.user_role.UserRoleGetDTO;
import neo.setup.learn_center.dto.auth.user_role.UserRoleUpdateDTO;
import neo.setup.learn_center.entity.auth.user_role.AuthUserRole;
import neo.setup.learn_center.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UserRoleMapper extends GenericMapper<UserRoleCreateDTO, UserRoleUpdateDTO, UserRoleGetDTO, UserRoleDetailDTO, AuthUserRole> {
}
