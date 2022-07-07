package neo.setup.learn_center.service.auth.user_role;

import neo.setup.learn_center.criteria.auth.user_role.UserRoleCriteria;
import neo.setup.learn_center.dto.auth.user_role.UserRoleCreateDTO;
import neo.setup.learn_center.dto.auth.user_role.UserRoleDetailDTO;
import neo.setup.learn_center.dto.auth.user_role.UserRoleGetDTO;
import neo.setup.learn_center.dto.auth.user_role.UserRoleUpdateDTO;
import neo.setup.learn_center.service.GenericCUDService;
import neo.setup.learn_center.service.GenericGLDService;

import java.util.UUID;

public interface UserRoleService extends GenericCUDService<UserRoleCreateDTO, UserRoleUpdateDTO, UUID>, GenericGLDService<UserRoleGetDTO, UserRoleDetailDTO, UserRoleCriteria, UUID> {
}
