package neo.setup.learn_center.criteria.course.course_price;

import lombok.Getter;
import lombok.Setter;
import neo.setup.learn_center.criteria.GenericCriteria;
import neo.setup.learn_center.enums.course.course_price.CoursePriceFieldsEnum;
import org.springdoc.api.annotations.ParameterObject;

@Getter
@Setter
@ParameterObject
public class CoursePriceCriteria extends GenericCriteria {
    private CoursePriceFieldsEnum fieldsEnum;
}
