package neo.setup.learn_center.mapper.auth.language;

import neo.setup.learn_center.dto.auth.language.LanguageCreateDTO;
import neo.setup.learn_center.dto.auth.language.LanguageDetailDTO;
import neo.setup.learn_center.dto.auth.language.LanguageGetDTO;
import neo.setup.learn_center.dto.auth.language.LanguageUpdateDTO;
import neo.setup.learn_center.entity.auth.language.Language;
import neo.setup.learn_center.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface LanguageMapper extends GenericMapper<LanguageCreateDTO, LanguageUpdateDTO, LanguageGetDTO, LanguageDetailDTO, Language> {
}
