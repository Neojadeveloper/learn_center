package neo.setup.learn_center.criteria.auth.language;

import lombok.Getter;
import lombok.Setter;
import neo.setup.learn_center.criteria.GenericCriteria;
import neo.setup.learn_center.enums.auth.language.LanguageFieldsEnum;
import org.springdoc.api.annotations.ParameterObject;

@Getter
@Setter
@ParameterObject
public class LanguageCriteria extends GenericCriteria {
    private LanguageFieldsEnum fieldsEnum;
}
