package neo.setup.learn_center.criteria.course.course_category;

import lombok.Getter;
import lombok.Setter;
import neo.setup.learn_center.criteria.GenericCriteria;
import neo.setup.learn_center.enums.course.course_category.CourseCategoryFieldsEnum;
import org.springdoc.api.annotations.ParameterObject;

@Getter
@Setter
@ParameterObject
public class CourseCategoryCriteria extends GenericCriteria {
    private CourseCategoryFieldsEnum fieldsEnum;
}
