package neo.setup.learn_center.service.system.faq;

import neo.setup.learn_center.criteria.system.faq.FaqCriteria;
import neo.setup.learn_center.dto.system.faq.FaqCreateDTO;
import neo.setup.learn_center.dto.system.faq.FaqDetailDTO;
import neo.setup.learn_center.dto.system.faq.FaqGetDTO;
import neo.setup.learn_center.dto.system.faq.FaqUpdateDTO;
import neo.setup.learn_center.service.GenericCUDService;
import neo.setup.learn_center.service.GenericGLDService;

import java.util.UUID;

public interface FaqService extends GenericCUDService<FaqCreateDTO, FaqUpdateDTO, UUID>, GenericGLDService<FaqGetDTO, FaqDetailDTO, FaqCriteria, UUID> {
}
