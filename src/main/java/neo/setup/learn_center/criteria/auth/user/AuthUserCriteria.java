package neo.setup.learn_center.criteria.auth.user;

import lombok.Getter;
import lombok.Setter;
import neo.setup.learn_center.criteria.GenericCriteria;
import neo.setup.learn_center.enums.auth.user.AuthUserFieldsEnum;
import org.springdoc.api.annotations.ParameterObject;

@Getter
@Setter
@ParameterObject
public class AuthUserCriteria extends GenericCriteria {
    private AuthUserFieldsEnum fieldsEnum;
}
