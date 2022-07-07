package neo.setup.learn_center.criteria.auth.role;

import lombok.Getter;
import lombok.Setter;
import neo.setup.learn_center.criteria.GenericCriteria;
import neo.setup.learn_center.enums.auth.role.RoleFieldsEnum;
import org.springdoc.api.annotations.ParameterObject;

@Getter
@Setter
@ParameterObject
public class RoleCriteria extends GenericCriteria {
    private RoleFieldsEnum fieldsEnum;
}
