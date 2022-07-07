package neo.setup.learn_center.criteria.course.course;

import lombok.Getter;
import lombok.Setter;
import neo.setup.learn_center.criteria.GenericCriteria;
import neo.setup.learn_center.enums.course.course.CourseFieldsEnum;
import org.springdoc.api.annotations.ParameterObject;

@Getter
@Setter
@ParameterObject
public class CourseCriteria extends GenericCriteria {
    private CourseFieldsEnum fieldsEnum;
}
