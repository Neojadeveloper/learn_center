package neo.setup.learn_center.service.course.course_certificate;

import neo.setup.learn_center.criteria.course.course_certificate.CourseCertificateCriteria;
import neo.setup.learn_center.dto.course.course_certificate.CourseCertificateCreateDTO;
import neo.setup.learn_center.dto.course.course_certificate.CourseCertificateDetailDTO;
import neo.setup.learn_center.dto.course.course_certificate.CourseCertificateGetDTO;
import neo.setup.learn_center.dto.course.course_certificate.CourseCertificateUpdateDTO;
import neo.setup.learn_center.service.GenericCUDService;
import neo.setup.learn_center.service.GenericGLDService;

import java.util.UUID;

public interface CourseCertificateService extends GenericCUDService<CourseCertificateCreateDTO, CourseCertificateUpdateDTO, UUID>, GenericGLDService<CourseCertificateGetDTO, CourseCertificateDetailDTO, CourseCertificateCriteria, UUID> {
}
