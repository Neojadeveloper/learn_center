package neo.setup.learn_center.criteria.blog.blog;

import lombok.Getter;
import lombok.Setter;
import neo.setup.learn_center.criteria.GenericCriteria;
import neo.setup.learn_center.enums.blog.blog.BlogFieldsEnum;
import org.springdoc.api.annotations.ParameterObject;

@Getter
@Setter
@ParameterObject
public class BlogCriteria extends GenericCriteria {
    private BlogFieldsEnum fieldsEnum;
}
