package neo.setup.learn_center.criteria.system.skill;

import lombok.Getter;
import lombok.Setter;
import neo.setup.learn_center.criteria.GenericCriteria;
import neo.setup.learn_center.enums.system.skill.SkillFieldsEnum;
import org.springdoc.api.annotations.ParameterObject;

@Getter
@Setter
@ParameterObject
public class SkillCriteria extends GenericCriteria {
    private SkillFieldsEnum fieldsEnum;
}
