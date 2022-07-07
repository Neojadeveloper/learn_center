package neo.setup.learn_center.criteria.blog.blog_category;

import lombok.Getter;
import lombok.Setter;
import neo.setup.learn_center.criteria.GenericCriteria;
import neo.setup.learn_center.enums.blog.blog_category.BlogCategoryFieldsEnum;
import org.springdoc.api.annotations.ParameterObject;

@Getter
@Setter
@ParameterObject
public class BlogCategoryCriteria extends GenericCriteria {
    private BlogCategoryFieldsEnum fieldsEnum;
}
