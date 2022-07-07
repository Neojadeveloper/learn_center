package neo.setup.learn_center.criteria.system.transaction;

import lombok.Getter;
import lombok.Setter;
import neo.setup.learn_center.criteria.GenericCriteria;
import neo.setup.learn_center.enums.system.transaction.TransactionFieldsEnum;
import org.springdoc.api.annotations.ParameterObject;

@Getter
@Setter
@ParameterObject
public class TransactionCriteria extends GenericCriteria {
    private TransactionFieldsEnum fieldsEnum;
}
