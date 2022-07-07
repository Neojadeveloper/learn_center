package neo.setup.learn_center.validator.course.course_level;

import neo.setup.learn_center.dto.course.course_level.CourseLevelCreateDTO;
import neo.setup.learn_center.dto.course.course_level.CourseLevelUpdateDTO;
import neo.setup.learn_center.exception.exception.InvalidValidationException;
import neo.setup.learn_center.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class CourseLevelValidator extends AbstractValidator<CourseLevelCreateDTO, CourseLevelUpdateDTO, UUID> {
    @Override
    public void validOnCreate(CourseLevelCreateDTO courseLevelCreateDTO) throws InvalidValidationException {
        if (Objects.isNull(courseLevelCreateDTO)) {
            throw new InvalidValidationException("DTO is null");
        }
    }

    @Override
    public void validOnUpdate(CourseLevelUpdateDTO courseLevelUpdateDTO) throws InvalidValidationException {
        if (Objects.isNull(courseLevelUpdateDTO)) {
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
