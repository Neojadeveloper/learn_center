package neo.setup.learn_center.validator.blog.blog_rating;

import neo.setup.learn_center.dto.blog.blog_rating.BlogRatingCreateDTO;
import neo.setup.learn_center.dto.blog.blog_rating.BlogRatingUpdateDTO;
import neo.setup.learn_center.exception.exception.InvalidValidationException;
import neo.setup.learn_center.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class BlogRatingValidator extends AbstractValidator<BlogRatingCreateDTO, BlogRatingUpdateDTO, UUID> {
    @Override
    public void validOnCreate(BlogRatingCreateDTO blogRatingCreateDTO) throws InvalidValidationException {
        if (Objects.isNull(blogRatingCreateDTO)) {
            throw new InvalidValidationException("DTO is null");
        }
    }

    @Override
    public void validOnUpdate(BlogRatingUpdateDTO blogRatingUpdateDTO) throws InvalidValidationException {
        if (Objects.isNull(blogRatingUpdateDTO)) {
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
