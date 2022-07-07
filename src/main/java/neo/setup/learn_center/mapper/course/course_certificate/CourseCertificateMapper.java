package neo.setup.learn_center.mapper.course.course_certificate;

import neo.setup.learn_center.dto.course.course_certificate.CourseCertificateCreateDTO;
import neo.setup.learn_center.dto.course.course_certificate.CourseCertificateDetailDTO;
import neo.setup.learn_center.dto.course.course_certificate.CourseCertificateGetDTO;
import neo.setup.learn_center.dto.course.course_certificate.CourseCertificateUpdateDTO;
import neo.setup.learn_center.entity.course.course_certificate.CourseCertificate;
import neo.setup.learn_center.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CourseCertificateMapper extends GenericMapper<CourseCertificateCreateDTO, CourseCertificateUpdateDTO, CourseCertificateGetDTO, CourseCertificateDetailDTO, CourseCertificate> {
}
