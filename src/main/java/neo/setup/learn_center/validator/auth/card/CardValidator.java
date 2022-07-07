package neo.setup.learn_center.validator.auth.card;

import neo.setup.learn_center.dto.auth.card.CardCreateDTO;
import neo.setup.learn_center.dto.auth.card.CardUpdateDTO;
import neo.setup.learn_center.exception.exception.InvalidValidationException;
import neo.setup.learn_center.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class CardValidator extends AbstractValidator<CardCreateDTO, CardUpdateDTO, UUID> {
    @Override
    public void validOnCreate(CardCreateDTO cardCreateDTO) throws InvalidValidationException {
        if (Objects.isNull(cardCreateDTO)) {
            throw new InvalidValidationException("DTO is null");
        }
    }

    @Override
    public void validOnUpdate(CardUpdateDTO cd) throws InvalidValidationException {
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
