package neo.setup.learn_center.criteria.auth.payment;

import lombok.Getter;
import lombok.Setter;
import neo.setup.learn_center.criteria.GenericCriteria;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Sort;

@Getter
@Setter
@ParameterObject
public class PaymentCriteria extends GenericCriteria {
    public PaymentCriteria(Integer size, Integer page, Sort.Direction sort) {
        super(size, page, sort);
    }
}
