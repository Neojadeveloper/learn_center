package neo.setup.learn_center.validator.auth.user;

import neo.setup.learn_center.dto.auth.user.AuthUserCreateDTO;
import neo.setup.learn_center.dto.auth.user.AuthUserUpdateDTO;
import neo.setup.learn_center.exception.exception.InvalidValidationException;
import neo.setup.learn_center.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class AuthUserValidator extends AbstractValidator<AuthUserCreateDTO, AuthUserUpdateDTO, UUID> {
    @Override
    public void validOnCreate(AuthUserCreateDTO authUserCreateDTO) throws InvalidValidationException {
        if (Objects.isNull(authUserCreateDTO)) {
            throw new InvalidValidationException("DTO is null");
        }
    }

    @Override
    public void validOnUpdate(AuthUserUpdateDTO cd) throws InvalidValidationException {
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
