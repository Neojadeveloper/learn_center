package neo.setup.learn_center.criteria.auth.block;

import lombok.Getter;
import lombok.Setter;
import neo.setup.learn_center.criteria.GenericCriteria;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Sort;

@Getter
@Setter
@ParameterObject
public class AuthBlockCriteria extends GenericCriteria {
    public AuthBlockCriteria(Integer size, Integer page, Sort.Direction sort) {
        super(size, page, sort);
    }
}
