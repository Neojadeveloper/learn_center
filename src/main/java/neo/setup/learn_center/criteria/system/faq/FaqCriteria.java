package neo.setup.learn_center.criteria.system.faq;

import lombok.Getter;
import lombok.Setter;
import neo.setup.learn_center.criteria.GenericCriteria;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Sort;

@Getter
@Setter
@ParameterObject
public class FaqCriteria extends GenericCriteria {
    public FaqCriteria(Integer size, Integer page, Sort.Direction sort) {
        super(size, page, sort);
    }
}
