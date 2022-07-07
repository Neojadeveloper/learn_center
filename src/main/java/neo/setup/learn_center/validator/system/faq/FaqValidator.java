package neo.setup.learn_center.validator.system.faq;

import neo.setup.learn_center.dto.system.faq.FaqCreateDTO;
import neo.setup.learn_center.dto.system.faq.FaqUpdateDTO;
import neo.setup.learn_center.exception.exception.InvalidValidationException;
import neo.setup.learn_center.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class FaqValidator extends AbstractValidator<FaqCreateDTO, FaqUpdateDTO, UUID> {
    @Override
    public void validOnCreate(FaqCreateDTO faqCreateDTO) throws InvalidValidationException {
        if (Objects.isNull(faqCreateDTO)) {
            throw new InvalidValidationException("DTO is null");
        }
    }

    @Override
    public void validOnUpdate(FaqUpdateDTO cd) throws InvalidValidationException {
        if (Objects.isNull(cd)) {
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
