package neo.setup.learn_center.validator.blog.blog;

import neo.setup.learn_center.dto.blog.blog.BlogCreateDTO;
import neo.setup.learn_center.dto.blog.blog.BlogUpdateDTO;
import neo.setup.learn_center.exception.exception.InvalidValidationException;
import neo.setup.learn_center.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class BlogValidator extends AbstractValidator<BlogCreateDTO, BlogUpdateDTO, UUID> {
    @Override
    public void validOnCreate(BlogCreateDTO blogCreateDTO) throws InvalidValidationException {
        if (Objects.isNull(blogCreateDTO)) {
            throw new InvalidValidationException("DTO is null");
        }
    }

    @Override
    public void validOnUpdate(BlogUpdateDTO blogUpdateDTO) throws InvalidValidationException {
        if (Objects.isNull(blogUpdateDTO)) {
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
