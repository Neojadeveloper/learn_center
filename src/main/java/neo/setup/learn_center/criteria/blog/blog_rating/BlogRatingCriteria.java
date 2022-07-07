package neo.setup.learn_center.criteria.blog.blog_rating;

import lombok.Getter;
import lombok.Setter;
import neo.setup.learn_center.criteria.GenericCriteria;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Sort;

@Getter
@Setter
@ParameterObject
public class BlogRatingCriteria extends GenericCriteria {
    public BlogRatingCriteria(Integer size, Integer page, Sort.Direction sort) {
        super(size, page, sort);
    }
}
