package neo.setup.learn_center.controller.auth.card;

import neo.setup.learn_center.controller.GenericCUDController;
import neo.setup.learn_center.controller.GenericGLDController;
import neo.setup.learn_center.criteria.auth.card.CardCriteria;
import neo.setup.learn_center.dto.auth.card.CardCreateDTO;
import neo.setup.learn_center.dto.auth.card.CardDetailDTO;
import neo.setup.learn_center.dto.auth.card.CardGetDTO;
import neo.setup.learn_center.dto.auth.card.CardUpdateDTO;

import java.util.UUID;

public interface CardController extends GenericCUDController<CardCreateDTO, CardUpdateDTO, UUID>, GenericGLDController<CardGetDTO, CardDetailDTO, CardCriteria, UUID> {
}
