package neo.setup.learn_center.criteria.system.transaction_status;

import lombok.Getter;
import lombok.Setter;
import neo.setup.learn_center.criteria.GenericCriteria;
import neo.setup.learn_center.enums.system.transaction_status.TransactionStatusFieldsEnum;
import org.springdoc.api.annotations.ParameterObject;

@Getter
@Setter
@ParameterObject
public class TransactionStatusCriteria extends GenericCriteria {
    private TransactionStatusFieldsEnum fieldsEnum;
}
