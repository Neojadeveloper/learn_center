package neo.setup.learn_center.validator.course.course_rating;

import neo.setup.learn_center.dto.course.course_rating.CourseRatingCreateDTO;
import neo.setup.learn_center.dto.course.course_rating.CourseRatingUpdateDTO;
import neo.setup.learn_center.exception.exception.InvalidValidationException;
import neo.setup.learn_center.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class CourseRatingValidator extends AbstractValidator<CourseRatingCreateDTO, CourseRatingUpdateDTO, UUID> {
    @Override
    public void validOnCreate(CourseRatingCreateDTO courseRatingCreateDTO) throws InvalidValidationException {
        if (Objects.isNull(courseRatingCreateDTO)) {
            throw new InvalidValidationException("DTO is null");
        }
    }

    @Override
    public void validOnUpdate(CourseRatingUpdateDTO courseRatingUpdateDTO) throws InvalidValidationException {
        if (Objects.isNull(courseRatingUpdateDTO)) {
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
