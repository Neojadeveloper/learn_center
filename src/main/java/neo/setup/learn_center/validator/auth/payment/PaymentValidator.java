package neo.setup.learn_center.validator.auth.payment;

import neo.setup.learn_center.dto.auth.payment.PaymentCreateDTO;
import neo.setup.learn_center.dto.auth.payment.PaymentUpdateDTO;
import neo.setup.learn_center.exception.exception.InvalidValidationException;
import neo.setup.learn_center.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class PaymentValidator extends AbstractValidator<PaymentCreateDTO, PaymentUpdateDTO, UUID> {
    @Override
    public void validOnCreate(PaymentCreateDTO paymentCreateDTO) throws InvalidValidationException {
        if (Objects.isNull(paymentCreateDTO)) {
            throw new InvalidValidationException("DTO is null");
        }
    }

    @Override
    public void validOnUpdate(PaymentUpdateDTO cd) throws InvalidValidationException {
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
