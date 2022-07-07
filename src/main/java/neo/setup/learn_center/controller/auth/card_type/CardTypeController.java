package neo.setup.learn_center.controller.auth.card_type;

import neo.setup.learn_center.controller.GenericCUDController;
import neo.setup.learn_center.controller.GenericGLDController;
import neo.setup.learn_center.criteria.auth.card_type.CardTypeCriteria;
import neo.setup.learn_center.dto.auth.card_type.CardTypeCreateDTO;
import neo.setup.learn_center.dto.auth.card_type.CardTypeDetailDTO;
import neo.setup.learn_center.dto.auth.card_type.CardTypeGetDTO;
import neo.setup.learn_center.dto.auth.card_type.CardTypeUpdateDTO;

import java.util.UUID;

public interface CardTypeController extends GenericCUDController<CardTypeCreateDTO, CardTypeUpdateDTO, UUID>, GenericGLDController<CardTypeGetDTO, CardTypeDetailDTO, CardTypeCriteria, UUID> {
}
