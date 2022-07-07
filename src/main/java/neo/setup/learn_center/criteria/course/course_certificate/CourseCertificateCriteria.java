package neo.setup.learn_center.criteria.course.course_certificate;

import lombok.Getter;
import lombok.Setter;
import neo.setup.learn_center.criteria.GenericCriteria;
import neo.setup.learn_center.enums.course.course_certificate.CourseCertificateFieldsEnum;
import org.springdoc.api.annotations.ParameterObject;

@Getter
@Setter
@ParameterObject
public class CourseCertificateCriteria extends GenericCriteria {
    private CourseCertificateFieldsEnum fieldsEnum;
}
