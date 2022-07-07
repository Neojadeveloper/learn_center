package neo.setup.learn_center.mapper.system.faq;

import neo.setup.learn_center.dto.system.faq.FaqCreateDTO;
import neo.setup.learn_center.dto.system.faq.FaqDetailDTO;
import neo.setup.learn_center.dto.system.faq.FaqGetDTO;
import neo.setup.learn_center.dto.system.faq.FaqUpdateDTO;
import neo.setup.learn_center.entity.system.faq.Faq;
import neo.setup.learn_center.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface FaqMapper extends GenericMapper<FaqCreateDTO, FaqUpdateDTO, FaqGetDTO, FaqDetailDTO, Faq> {
}
