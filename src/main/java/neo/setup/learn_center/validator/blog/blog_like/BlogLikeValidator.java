package neo.setup.learn_center.validator.blog.blog_like;

import neo.setup.learn_center.dto.blog.blog_like.BlogLikeCreateDTO;
import neo.setup.learn_center.dto.blog.blog_like.BlogLikeUpdateDTO;
import neo.setup.learn_center.exception.exception.InvalidValidationException;
import neo.setup.learn_center.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class BlogLikeValidator extends AbstractValidator<BlogLikeCreateDTO, BlogLikeUpdateDTO, UUID> {
    @Override
    public void validOnCreate(BlogLikeCreateDTO blogLikeCreateDTO) throws InvalidValidationException {
        if (Objects.isNull(blogLikeCreateDTO)) {
            throw new InvalidValidationException("DTO is null");
        }
    }

    @Override
    public void validOnUpdate(BlogLikeUpdateDTO cd) throws InvalidValidationException {
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
