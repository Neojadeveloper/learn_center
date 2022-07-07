package neo.setup.learn_center.service.auth.card;

import neo.setup.learn_center.criteria.auth.card.CardCriteria;
import neo.setup.learn_center.dto.auth.card.CardCreateDTO;
import neo.setup.learn_center.dto.auth.card.CardDetailDTO;
import neo.setup.learn_center.dto.auth.card.CardGetDTO;
import neo.setup.learn_center.dto.auth.card.CardUpdateDTO;
import neo.setup.learn_center.service.GenericCUDService;
import neo.setup.learn_center.service.GenericGLDService;

import java.util.UUID;

public interface CardService extends GenericCUDService<CardCreateDTO, CardUpdateDTO, UUID>, GenericGLDService<CardGetDTO, CardDetailDTO, CardCriteria, UUID> {
}
