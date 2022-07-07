package neo.setup.learn_center.validator.course.course_price;

import neo.setup.learn_center.dto.course.course_price.CoursePriceCreateDTO;
import neo.setup.learn_center.dto.course.course_price.CoursePriceUpdateDTO;
import neo.setup.learn_center.exception.exception.InvalidValidationException;
import neo.setup.learn_center.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class CoursePriceValidator extends AbstractValidator<CoursePriceCreateDTO, CoursePriceUpdateDTO, UUID> {
    @Override
    public void validOnCreate(CoursePriceCreateDTO coursePriceCreateDTO) throws InvalidValidationException {
        if (Objects.isNull(coursePriceCreateDTO)) {
            throw new InvalidValidationException("DTO is null");
        }
    }

    @Override
    public void validOnUpdate(CoursePriceUpdateDTO coursePriceUpdateDTO) throws InvalidValidationException {
        if (Objects.isNull(coursePriceUpdateDTO)) {
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
