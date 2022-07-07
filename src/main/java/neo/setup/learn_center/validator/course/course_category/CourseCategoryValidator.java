package neo.setup.learn_center.validator.course.course_category;

import neo.setup.learn_center.dto.course.course_category.CourseCategoryCreateDTO;
import neo.setup.learn_center.dto.course.course_category.CourseCategoryUpdateDTO;
import neo.setup.learn_center.exception.exception.InvalidValidationException;
import neo.setup.learn_center.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class CourseCategoryValidator extends AbstractValidator<CourseCategoryCreateDTO, CourseCategoryUpdateDTO, UUID> {
    @Override
    public void validOnCreate(CourseCategoryCreateDTO courseCategoryCreateDTO) throws InvalidValidationException {
        if (Objects.isNull(courseCategoryCreateDTO)) {
            throw new InvalidValidationException("DTO is null");
        }
    }

    @Override
    public void validOnUpdate(CourseCategoryUpdateDTO courseCategoryUpdateDTO) throws InvalidValidationException {
        if (Objects.isNull(courseCategoryUpdateDTO)) {
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
