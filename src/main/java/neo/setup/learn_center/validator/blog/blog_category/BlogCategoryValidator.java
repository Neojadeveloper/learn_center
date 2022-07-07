package neo.setup.learn_center.validator.blog.blog_category;

import neo.setup.learn_center.dto.blog.blog_category.BlogCategoryCreateDTO;
import neo.setup.learn_center.dto.blog.blog_category.BlogCategoryUpdateDTO;
import neo.setup.learn_center.exception.exception.InvalidValidationException;
import neo.setup.learn_center.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class BlogCategoryValidator extends AbstractValidator<BlogCategoryCreateDTO, BlogCategoryUpdateDTO, UUID> {
    @Override
    public void validOnCreate(BlogCategoryCreateDTO blogCategoryCreateDTO) throws InvalidValidationException {
        if (Objects.isNull(blogCategoryCreateDTO)) {
            throw new InvalidValidationException("DTO is null");
        }
    }

    @Override
    public void validOnUpdate(BlogCategoryUpdateDTO cd) throws InvalidValidationException {
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
