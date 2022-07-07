package neo.setup.learn_center.service.course.course_certificate_user;

import neo.setup.learn_center.criteria.course.course_certificate_user.CourseCertificateUserCriteria;
import neo.setup.learn_center.dto.course.course_certificate_user.CourseCertificateUserCreateDTO;
import neo.setup.learn_center.dto.course.course_certificate_user.CourseCertificateUserDetailDTO;
import neo.setup.learn_center.dto.course.course_certificate_user.CourseCertificateUserGetDTO;
import neo.setup.learn_center.dto.course.course_certificate_user.CourseCertificateUserUpdateDTO;
import neo.setup.learn_center.service.GenericCUDService;
import neo.setup.learn_center.service.GenericGLDService;

import java.util.UUID;

public interface CourseCertificateUserService extends GenericCUDService<CourseCertificateUserCreateDTO, CourseCertificateUserUpdateDTO, UUID>, GenericGLDService<CourseCertificateUserGetDTO, CourseCertificateUserDetailDTO, CourseCertificateUserCriteria, UUID> {
}
