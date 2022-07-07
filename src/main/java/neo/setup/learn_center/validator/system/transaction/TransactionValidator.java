package neo.setup.learn_center.validator.system.transaction;

import neo.setup.learn_center.dto.system.transaction.TransactionCreateDTO;
import neo.setup.learn_center.dto.system.transaction.TransactionUpdateDTO;
import neo.setup.learn_center.exception.exception.InvalidValidationException;
import neo.setup.learn_center.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class TransactionValidator extends AbstractValidator<TransactionCreateDTO, TransactionUpdateDTO, UUID> {
    @Override
    public void validOnCreate(TransactionCreateDTO transactionCreateDTO) throws InvalidValidationException {
        if (Objects.isNull(transactionCreateDTO)) {
            throw new InvalidValidationException("DTO is null");
        }
    }

    @Override
    public void validOnUpdate(TransactionUpdateDTO cd) throws InvalidValidationException {
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
