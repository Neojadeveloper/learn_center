package neo.setup.learn_center.criteria.auth.block_reason;

import lombok.Getter;
import lombok.Setter;
import neo.setup.learn_center.criteria.GenericCriteria;
import neo.setup.learn_center.enums.auth.block_reason.BlockReasonFieldsEnum;
import org.springdoc.api.annotations.ParameterObject;

@Getter
@Setter
@ParameterObject
public class BlockReasonCriteria extends GenericCriteria {
    private BlockReasonFieldsEnum fieldsEnum;
}
