package neo.setup.learn_center.controller.course.course_certificate_user;

import neo.setup.learn_center.controller.GenericCUDController;
import neo.setup.learn_center.controller.GenericGLDController;
import neo.setup.learn_center.criteria.course.course_certificate_user.CourseCertificateUserCriteria;
import neo.setup.learn_center.dto.course.course_certificate_user.CourseCertificateUserCreateDTO;
import neo.setup.learn_center.dto.course.course_certificate_user.CourseCertificateUserDetailDTO;
import neo.setup.learn_center.dto.course.course_certificate_user.CourseCertificateUserGetDTO;
import neo.setup.learn_center.dto.course.course_certificate_user.CourseCertificateUserUpdateDTO;

import java.util.UUID;

public interface CourseCertificateUserController extends GenericCUDController<CourseCertificateUserCreateDTO, CourseCertificateUserUpdateDTO, UUID>, GenericGLDController<CourseCertificateUserGetDTO, CourseCertificateUserDetailDTO, CourseCertificateUserCriteria, UUID> {

}
