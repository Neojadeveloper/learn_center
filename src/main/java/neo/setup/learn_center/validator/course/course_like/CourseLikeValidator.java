package neo.setup.learn_center.validator.course.course_like;

import neo.setup.learn_center.dto.course.course_like.CourseLikeCreateDTO;
import neo.setup.learn_center.dto.course.course_like.CourseLikeUpdateDTO;
import neo.setup.learn_center.exception.exception.InvalidValidationException;
import neo.setup.learn_center.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class CourseLikeValidator extends AbstractValidator<CourseLikeCreateDTO, CourseLikeUpdateDTO, UUID> {
    @Override
    public void validOnCreate(CourseLikeCreateDTO courseLikeCreateDTO) throws InvalidValidationException {
        if (Objects.isNull(courseLikeCreateDTO)) {
            throw new InvalidValidationException("DTO is null");
        }
    }

    @Override
    public void validOnUpdate(CourseLikeUpdateDTO courseLikeUpdateDTO) throws InvalidValidationException {
        if (Objects.isNull(courseLikeUpdateDTO)) {
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
