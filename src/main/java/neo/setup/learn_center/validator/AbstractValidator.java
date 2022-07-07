package neo.setup.learn_center.validator;

import neo.setup.learn_center.dto.BaseDTO;
import neo.setup.learn_center.dto.GenericDTO;
import neo.setup.learn_center.exception.exception.InvalidValidationException;

import java.io.Serializable;

public abstract class AbstractValidator<CD extends BaseDTO, UD extends GenericDTO, K extends Serializable> implements BaseValidator {
    public abstract void validOnCreate(CD cd) throws InvalidValidationException;

    public abstract void validOnUpdate(UD ud) throws InvalidValidationException;

    public abstract void validateKey(K id) throws InvalidValidationException;
}
