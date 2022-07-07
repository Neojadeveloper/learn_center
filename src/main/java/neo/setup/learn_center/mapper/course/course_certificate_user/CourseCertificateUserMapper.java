package neo.setup.learn_center.mapper.course.course_certificate_user;

import neo.setup.learn_center.dto.course.course_certificate_user.CourseCertificateUserCreateDTO;
import neo.setup.learn_center.dto.course.course_certificate_user.CourseCertificateUserDetailDTO;
import neo.setup.learn_center.dto.course.course_certificate_user.CourseCertificateUserGetDTO;
import neo.setup.learn_center.dto.course.course_certificate_user.CourseCertificateUserUpdateDTO;
import neo.setup.learn_center.entity.course.course_certificate_user.CourseCertificateUser;
import neo.setup.learn_center.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CourseCertificateUserMapper extends GenericMapper<CourseCertificateUserCreateDTO, CourseCertificateUserUpdateDTO, CourseCertificateUserGetDTO, CourseCertificateUserDetailDTO, CourseCertificateUser> {
}
