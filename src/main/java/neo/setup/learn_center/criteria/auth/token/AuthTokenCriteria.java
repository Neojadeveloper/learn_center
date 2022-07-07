package neo.setup.learn_center.criteria.auth.token;

import lombok.Getter;
import lombok.Setter;
import neo.setup.learn_center.criteria.GenericCriteria;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Sort;

@Getter
@Setter
@ParameterObject
public class AuthTokenCriteria extends GenericCriteria {
    public AuthTokenCriteria(Integer size, Integer page, Sort.Direction sort) {
        super(size, page, sort);
    }
}
