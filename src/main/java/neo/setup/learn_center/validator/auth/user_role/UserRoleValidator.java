package neo.setup.learn_center.validator.auth.user_role;

import neo.setup.learn_center.dto.auth.user_role.UserRoleCreateDTO;
import neo.setup.learn_center.dto.auth.user_role.UserRoleUpdateDTO;
import neo.setup.learn_center.exception.exception.InvalidValidationException;
import neo.setup.learn_center.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class UserRoleValidator extends AbstractValidator<UserRoleCreateDTO, UserRoleUpdateDTO, UUID> {
    @Override
    public void validOnCreate(UserRoleCreateDTO userRoleCreateDTO) throws InvalidValidationException {
        if (Objects.isNull(userRoleCreateDTO)) {
            throw new InvalidValidationException("DTO is null");
        }
    }

    @Override
    public void validOnUpdate(UserRoleUpdateDTO cd) throws InvalidValidationException {
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
