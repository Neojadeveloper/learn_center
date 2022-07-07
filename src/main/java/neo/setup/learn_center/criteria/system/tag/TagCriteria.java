package neo.setup.learn_center.criteria.system.tag;

import lombok.Getter;
import lombok.Setter;
import neo.setup.learn_center.criteria.GenericCriteria;
import neo.setup.learn_center.enums.system.tag.TagFieldsEnum;
import org.springdoc.api.annotations.ParameterObject;

@Getter
@Setter
@ParameterObject
public class TagCriteria extends GenericCriteria {
    private TagFieldsEnum fieldsEnum;
}
