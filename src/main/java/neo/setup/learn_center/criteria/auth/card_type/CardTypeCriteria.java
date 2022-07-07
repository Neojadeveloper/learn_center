package neo.setup.learn_center.criteria.auth.card_type;

import lombok.Getter;
import lombok.Setter;
import neo.setup.learn_center.criteria.GenericCriteria;
import neo.setup.learn_center.enums.auth.card_type.CardTypeFieldsEnum;
import org.springdoc.api.annotations.ParameterObject;

@Getter
@Setter
@ParameterObject
public class CardTypeCriteria extends GenericCriteria {
    private CardTypeFieldsEnum fieldsEnum;
}
