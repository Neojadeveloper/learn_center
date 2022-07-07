package neo.setup.learn_center.service.auth.role;

import neo.setup.learn_center.criteria.auth.role.RoleCriteria;
import neo.setup.learn_center.dto.auth.role.RoleCreateDTO;
import neo.setup.learn_center.dto.auth.role.RoleDetailDTO;
import neo.setup.learn_center.dto.auth.role.RoleGetDTO;
import neo.setup.learn_center.dto.auth.role.RoleUpdateDTO;
import neo.setup.learn_center.service.GenericCUDService;
import neo.setup.learn_center.service.GenericGLDService;

import java.util.UUID;

public interface RoleService extends GenericCUDService<RoleCreateDTO, RoleUpdateDTO, UUID>, GenericGLDService<RoleGetDTO, RoleDetailDTO, RoleCriteria, UUID> {
}
