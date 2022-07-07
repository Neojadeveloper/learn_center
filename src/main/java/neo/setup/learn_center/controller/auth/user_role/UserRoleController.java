package neo.setup.learn_center.controller.auth.user_role;

import neo.setup.learn_center.controller.GenericCUDController;
import neo.setup.learn_center.controller.GenericGLDController;
import neo.setup.learn_center.criteria.auth.user_role.UserRoleCriteria;
import neo.setup.learn_center.dto.auth.user_role.UserRoleCreateDTO;
import neo.setup.learn_center.dto.auth.user_role.UserRoleDetailDTO;
import neo.setup.learn_center.dto.auth.user_role.UserRoleGetDTO;
import neo.setup.learn_center.dto.auth.user_role.UserRoleUpdateDTO;

import java.util.UUID;

public interface UserRoleController extends GenericCUDController<UserRoleCreateDTO, UserRoleUpdateDTO, UUID>, GenericGLDController<UserRoleGetDTO, UserRoleDetailDTO, UserRoleCriteria, UUID> {
}
