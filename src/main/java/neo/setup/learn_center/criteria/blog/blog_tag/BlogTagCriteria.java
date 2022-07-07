package neo.setup.learn_center.criteria.blog.blog_tag;

import lombok.Getter;
import lombok.Setter;
import neo.setup.learn_center.criteria.GenericCriteria;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Sort;

@Getter
@Setter
@ParameterObject
public class BlogTagCriteria extends GenericCriteria {
    public BlogTagCriteria(Integer size, Integer page, Sort.Direction sort) {
        super(size, page, sort);
    }
}
