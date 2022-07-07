package neo.setup.learn_center.validator.auth.card_type;

import neo.setup.learn_center.dto.auth.card_type.CardTypeCreateDTO;
import neo.setup.learn_center.dto.auth.card_type.CardTypeUpdateDTO;
import neo.setup.learn_center.exception.exception.InvalidValidationException;
import neo.setup.learn_center.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class CardTypeValidator extends AbstractValidator<CardTypeCreateDTO, CardTypeUpdateDTO, UUID> {
    @Override
    public void validOnCreate(CardTypeCreateDTO cardTypeCreateDTO) throws InvalidValidationException {
        if (Objects.isNull(cardTypeCreateDTO)) {
            throw new InvalidValidationException("DTO is null");
        }
    }

    @Override
    public void validOnUpdate(CardTypeUpdateDTO cd) throws InvalidValidationException {
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
