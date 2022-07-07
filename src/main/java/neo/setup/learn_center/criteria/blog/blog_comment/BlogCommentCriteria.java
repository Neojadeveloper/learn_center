package neo.setup.learn_center.criteria.blog.blog_comment;

import lombok.Getter;
import lombok.Setter;
import neo.setup.learn_center.criteria.GenericCriteria;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Sort;

@Getter
@Setter
@ParameterObject
public class BlogCommentCriteria extends GenericCriteria {
    public BlogCommentCriteria(Integer size, Integer page, Sort.Direction sort) {
        super(size, page, sort);
    }
}
