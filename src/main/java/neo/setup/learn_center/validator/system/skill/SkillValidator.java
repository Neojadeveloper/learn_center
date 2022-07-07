package neo.setup.learn_center.validator.system.skill;

import neo.setup.learn_center.dto.system.skill.SkillCreateDTO;
import neo.setup.learn_center.dto.system.skill.SkillUpdateDTO;
import neo.setup.learn_center.exception.exception.InvalidValidationException;
import neo.setup.learn_center.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class SkillValidator extends AbstractValidator<SkillCreateDTO, SkillUpdateDTO, UUID> {
    @Override
    public void validOnCreate(SkillCreateDTO skillCreateDTO) throws InvalidValidationException {
        if (Objects.isNull(skillCreateDTO)) {
            throw new InvalidValidationException("DTO is null");
        }
    }

    @Override
    public void validOnUpdate(SkillUpdateDTO cd) throws InvalidValidationException {
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
