package neo.setup.learn_center.validator.blog.blog_tag;

import neo.setup.learn_center.dto.blog.blog_tag.BlogTagCreateDTO;
import neo.setup.learn_center.dto.blog.blog_tag.BlogTagUpdateDTO;
import neo.setup.learn_center.exception.exception.InvalidValidationException;
import neo.setup.learn_center.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class BlogTagValidator extends AbstractValidator<BlogTagCreateDTO, BlogTagUpdateDTO, UUID> {
    @Override
    public void validOnCreate(BlogTagCreateDTO blogTagCreateDTO) throws InvalidValidationException {
        if (Objects.isNull(blogTagCreateDTO)) {
            throw new InvalidValidationException("DTO is null");
        }
    }

    @Override
    public void validOnUpdate(BlogTagUpdateDTO blogTagUpdateDTO) throws InvalidValidationException {
        if (Objects.isNull(blogTagUpdateDTO)) {
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
