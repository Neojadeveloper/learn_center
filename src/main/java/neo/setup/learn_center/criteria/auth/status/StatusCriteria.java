package neo.setup.learn_center.criteria.auth.status;

import lombok.Getter;
import lombok.Setter;
import neo.setup.learn_center.criteria.GenericCriteria;
import neo.setup.learn_center.enums.auth.status.StatusFieldsEnum;
import org.springdoc.api.annotations.ParameterObject;

@Getter
@Setter
@ParameterObject
public class StatusCriteria extends GenericCriteria {
    private StatusFieldsEnum fieldsEnum;
}
