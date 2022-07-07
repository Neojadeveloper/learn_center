package neo.setup.learn_center.validator.auth.block_reason;

import neo.setup.learn_center.dto.auth.block_reason.BlockReasonCreateDTO;
import neo.setup.learn_center.dto.auth.block_reason.BlockReasonUpdateDTO;
import neo.setup.learn_center.exception.exception.InvalidValidationException;
import neo.setup.learn_center.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class BlockReasonValidator extends AbstractValidator<BlockReasonCreateDTO, BlockReasonUpdateDTO, UUID> {
    @Override
    public void validOnCreate(BlockReasonCreateDTO blockReasonCreateDTO) throws InvalidValidationException {
        if (Objects.isNull(blockReasonCreateDTO)) {
            throw new InvalidValidationException("DTO is null");
        }
    }

    @Override
    public void validOnUpdate(BlockReasonUpdateDTO cd) throws InvalidValidationException {
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
