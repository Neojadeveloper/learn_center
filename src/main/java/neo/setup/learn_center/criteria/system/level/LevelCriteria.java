package neo.setup.learn_center.criteria.system.level;

import lombok.Getter;
import lombok.Setter;
import neo.setup.learn_center.criteria.GenericCriteria;
import neo.setup.learn_center.enums.system.level.LevelFieldsEnum;
import org.springdoc.api.annotations.ParameterObject;

@Getter
@Setter
@ParameterObject
public class LevelCriteria extends GenericCriteria {
    private LevelFieldsEnum fieldsEnum;
}
