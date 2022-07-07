package neo.setup.learn_center.controller.auth.language;

import neo.setup.learn_center.controller.GenericCUDController;
import neo.setup.learn_center.controller.GenericGLDController;
import neo.setup.learn_center.criteria.auth.language.LanguageCriteria;
import neo.setup.learn_center.dto.auth.language.LanguageCreateDTO;
import neo.setup.learn_center.dto.auth.language.LanguageDetailDTO;
import neo.setup.learn_center.dto.auth.language.LanguageGetDTO;
import neo.setup.learn_center.dto.auth.language.LanguageUpdateDTO;

import java.util.UUID;

public interface LanguageController extends GenericCUDController<LanguageCreateDTO, LanguageUpdateDTO, UUID>, GenericGLDController<LanguageGetDTO, LanguageDetailDTO, LanguageCriteria, UUID> {
}
