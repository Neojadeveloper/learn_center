package neo.setup.learn_center.validator.course.course;

import neo.setup.learn_center.dto.course.course.CourseCreateDTO;
import neo.setup.learn_center.dto.course.course.CourseUpdateDTO;
import neo.setup.learn_center.exception.exception.InvalidValidationException;
import neo.setup.learn_center.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class CourseValidator extends AbstractValidator<CourseCreateDTO, CourseUpdateDTO, UUID> {
    @Override
    public void validOnCreate(CourseCreateDTO courseCreateDTO) throws InvalidValidationException {
        if (Objects.isNull(courseCreateDTO)) {
            throw new InvalidValidationException("DTO is null");
        }
    }

    @Override
    public void validOnUpdate(CourseUpdateDTO courseUpdateDTO) throws InvalidValidationException {
        if (Objects.isNull(courseUpdateDTO)) {
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
