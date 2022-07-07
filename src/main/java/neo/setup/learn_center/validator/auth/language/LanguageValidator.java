package neo.setup.learn_center.validator.auth.language;

import neo.setup.learn_center.dto.auth.language.LanguageCreateDTO;
import neo.setup.learn_center.dto.auth.language.LanguageUpdateDTO;
import neo.setup.learn_center.exception.exception.InvalidValidationException;
import neo.setup.learn_center.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class LanguageValidator extends AbstractValidator<LanguageCreateDTO, LanguageUpdateDTO, UUID> {
    @Override
    public void validOnCreate(LanguageCreateDTO languageCreateDTO) throws InvalidValidationException {
        if (Objects.isNull(languageCreateDTO)) {
            throw new InvalidValidationException("DTO is null");
        }
    }

    @Override
    public void validOnUpdate(LanguageUpdateDTO cd) throws InvalidValidationException {
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
