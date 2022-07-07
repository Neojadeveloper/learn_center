package neo.setup.learn_center.validator.course.course_certificate;

import neo.setup.learn_center.dto.course.course_certificate.CourseCertificateCreateDTO;
import neo.setup.learn_center.dto.course.course_certificate.CourseCertificateUpdateDTO;
import neo.setup.learn_center.exception.exception.InvalidValidationException;
import neo.setup.learn_center.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class CourseCertificateValidator extends AbstractValidator<CourseCertificateCreateDTO, CourseCertificateUpdateDTO, UUID> {
    @Override
    public void validOnCreate(CourseCertificateCreateDTO courseCertificateCreateDTO) throws InvalidValidationException {
        if (Objects.isNull(courseCertificateCreateDTO)) {
            throw new InvalidValidationException("DTO is null");
        }
    }

    @Override
    public void validOnUpdate(CourseCertificateUpdateDTO courseCertificateUpdateDTO) throws InvalidValidationException {
        if (Objects.isNull(courseCertificateUpdateDTO)) {
            throw new InvalidValidationException("DTO is null");
        }
    }

    @Override
    public void validateKey(UUID id) throws InvalidValidationException {
        if (Objects.isNull(id)) {
            throw new InvalidValidationException("ID is null");
        }
    }
}
