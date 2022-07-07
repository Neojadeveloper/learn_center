package neo.setup.learn_center.service.auth.language;

import neo.setup.learn_center.criteria.auth.language.LanguageCriteria;
import neo.setup.learn_center.dto.auth.language.LanguageCreateDTO;
import neo.setup.learn_center.dto.auth.language.LanguageDetailDTO;
import neo.setup.learn_center.dto.auth.language.LanguageGetDTO;
import neo.setup.learn_center.dto.auth.language.LanguageUpdateDTO;
import neo.setup.learn_center.service.GenericCUDService;
import neo.setup.learn_center.service.GenericGLDService;

import java.util.UUID;

public interface LanguageService extends GenericCUDService<LanguageCreateDTO, LanguageUpdateDTO, UUID>, GenericGLDService<LanguageGetDTO, LanguageDetailDTO, LanguageCriteria, UUID> {
}
