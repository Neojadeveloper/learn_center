package neo.setup.learn_center.controller.course.course_certificate;

import neo.setup.learn_center.controller.GenericCUDController;
import neo.setup.learn_center.controller.GenericGLDController;
import neo.setup.learn_center.criteria.course.course_certificate.CourseCertificateCriteria;
import neo.setup.learn_center.dto.course.course_certificate.CourseCertificateCreateDTO;
import neo.setup.learn_center.dto.course.course_certificate.CourseCertificateDetailDTO;
import neo.setup.learn_center.dto.course.course_certificate.CourseCertificateGetDTO;
import neo.setup.learn_center.dto.course.course_certificate.CourseCertificateUpdateDTO;

import java.util.UUID;

public interface CourseCertificateController extends GenericCUDController<CourseCertificateCreateDTO, CourseCertificateUpdateDTO, UUID>, GenericGLDController<CourseCertificateGetDTO, CourseCertificateDetailDTO, CourseCertificateCriteria, UUID> {
}
