package neo.setup.learn_center.validator.blog.blog_comment;

import neo.setup.learn_center.dto.blog.blog_comment.BlogCommentCreateDTO;
import neo.setup.learn_center.dto.blog.blog_comment.BlogCommentUpdateDTO;
import neo.setup.learn_center.exception.exception.InvalidValidationException;
import neo.setup.learn_center.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class BlogCommentValidator extends AbstractValidator<BlogCommentCreateDTO, BlogCommentUpdateDTO, UUID> {
    @Override
    public void validOnCreate(BlogCommentCreateDTO blogCommentCreateDTO) throws InvalidValidationException {
        if (Objects.isNull(blogCommentCreateDTO)) {
            throw new InvalidValidationException("DTO is null");
        }
    }

    @Override
    public void validOnUpdate(BlogCommentUpdateDTO cd) throws InvalidValidationException {
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
