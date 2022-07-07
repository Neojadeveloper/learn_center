package neo.setup.learn_center.validator.auth.token;


import neo.setup.learn_center.dto.auth.token.AuthTokenCreateDTO;
import neo.setup.learn_center.dto.auth.token.AuthTokenUpdateDTO;
import neo.setup.learn_center.exception.exception.InvalidValidationException;
import neo.setup.learn_center.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class AuthTokenValidator extends AbstractValidator<AuthTokenCreateDTO, AuthTokenUpdateDTO, UUID> {
    @Override
    public void validOnCreate(AuthTokenCreateDTO authTokenCreateDTO) throws InvalidValidationException {
        if (Objects.isNull(authTokenCreateDTO)) {
            throw new InvalidValidationException("DTO is null");
        }
    }

    @Override
    public void validOnUpdate(AuthTokenUpdateDTO cd) throws InvalidValidationException {
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
