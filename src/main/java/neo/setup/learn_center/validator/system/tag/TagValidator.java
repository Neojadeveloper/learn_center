package neo.setup.learn_center.validator.system.tag;

import neo.setup.learn_center.dto.system.tag.TagCreateDTO;
import neo.setup.learn_center.dto.system.tag.TagUpdateDTO;
import neo.setup.learn_center.exception.exception.InvalidValidationException;
import neo.setup.learn_center.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class TagValidator extends AbstractValidator<TagCreateDTO, TagUpdateDTO, UUID> {
    @Override
    public void validOnCreate(TagCreateDTO tagCreateDTO) throws InvalidValidationException {
        if (Objects.isNull(tagCreateDTO)) {
            throw new InvalidValidationException("DTO is null");
        }
    }

    @Override
    public void validOnUpdate(TagUpdateDTO cd) throws InvalidValidationException {
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
