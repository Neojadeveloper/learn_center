package neo.setup.learn_center.criteria.auth.user_role;

import lombok.Getter;
import lombok.Setter;
import neo.setup.learn_center.criteria.GenericCriteria;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Sort;

@Getter
@Setter
@ParameterObject
public class UserRoleCriteria extends GenericCriteria {
    public UserRoleCriteria(Integer size, Integer page, Sort.Direction sort) {
        super(size, page, sort);
    }
}
