package neo.setup.learn_center.mapper.auth.role;

import neo.setup.learn_center.dto.auth.role.RoleCreateDTO;
import neo.setup.learn_center.dto.auth.role.RoleDetailDTO;
import neo.setup.learn_center.dto.auth.role.RoleGetDTO;
import neo.setup.learn_center.dto.auth.role.RoleUpdateDTO;
import neo.setup.learn_center.entity.auth.role.Role;
import neo.setup.learn_center.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface RoleMapper extends GenericMapper<RoleCreateDTO, RoleUpdateDTO, RoleGetDTO, RoleDetailDTO, Role> {
}
