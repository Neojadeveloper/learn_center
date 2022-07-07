package neo.setup.learn_center.criteria.auth.card;

import lombok.Getter;
import lombok.Setter;
import neo.setup.learn_center.criteria.GenericCriteria;
import neo.setup.learn_center.enums.auth.card.CardFieldsEnum;
import org.springdoc.api.annotations.ParameterObject;

@Getter
@Setter
@ParameterObject
public class CardCriteria extends GenericCriteria {
    private CardFieldsEnum fieldsEnum;
}
