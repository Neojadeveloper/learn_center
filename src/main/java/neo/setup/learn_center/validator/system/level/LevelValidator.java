package neo.setup.learn_center.validator.system.level;

import neo.setup.learn_center.dto.system.level.LevelCreateDTO;
import neo.setup.learn_center.dto.system.level.LevelUpdateDTO;
import neo.setup.learn_center.exception.exception.InvalidValidationException;
import neo.setup.learn_center.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class LevelValidator extends AbstractValidator<LevelCreateDTO, LevelUpdateDTO, UUID> {
    @Override
    public void validOnCreate(LevelCreateDTO levelCreateDTO) throws InvalidValidationException {
        if (Objects.isNull(levelCreateDTO)) {
            throw new InvalidValidationException("DTO is null");
        }
    }

    @Override
    public void validOnUpdate(LevelUpdateDTO cd) throws InvalidValidationException {
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
