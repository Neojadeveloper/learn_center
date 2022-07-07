package neo.setup.learn_center.service.auth.card_type;

import neo.setup.learn_center.criteria.auth.card_type.CardTypeCriteria;
import neo.setup.learn_center.dto.auth.card_type.CardTypeCreateDTO;
import neo.setup.learn_center.dto.auth.card_type.CardTypeDetailDTO;
import neo.setup.learn_center.dto.auth.card_type.CardTypeGetDTO;
import neo.setup.learn_center.dto.auth.card_type.CardTypeUpdateDTO;
import neo.setup.learn_center.service.GenericCUDService;
import neo.setup.learn_center.service.GenericGLDService;

import java.util.UUID;

public interface CardTypeService extends GenericCUDService<CardTypeCreateDTO, CardTypeUpdateDTO, UUID>, GenericGLDService<CardTypeGetDTO, CardTypeDetailDTO, CardTypeCriteria, UUID> {
}
