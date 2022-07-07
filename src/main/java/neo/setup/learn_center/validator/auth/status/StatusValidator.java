package neo.setup.learn_center.validator.auth.status;

import neo.setup.learn_center.dto.auth.status.StatusCreateDTO;
import neo.setup.learn_center.dto.auth.status.StatusUpdateDTO;
import neo.setup.learn_center.exception.exception.InvalidValidationException;
import neo.setup.learn_center.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class StatusValidator extends AbstractValidator<StatusCreateDTO, StatusUpdateDTO, UUID> {
    @Override
    public void validOnCreate(StatusCreateDTO statusCreateDTO) throws InvalidValidationException {
        if (Objects.isNull(statusCreateDTO)) {
            throw new InvalidValidationException("DTO is null");
        }
    }

    @Override
    public void validOnUpdate(StatusUpdateDTO cd) throws InvalidValidationException {
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
