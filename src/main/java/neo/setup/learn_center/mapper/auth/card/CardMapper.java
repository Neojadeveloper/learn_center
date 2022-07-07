package neo.setup.learn_center.mapper.auth.card;

import neo.setup.learn_center.dto.auth.card.CardCreateDTO;
import neo.setup.learn_center.dto.auth.card.CardDetailDTO;
import neo.setup.learn_center.dto.auth.card.CardGetDTO;
import neo.setup.learn_center.dto.auth.card.CardUpdateDTO;
import neo.setup.learn_center.entity.auth.card.AuthCard;
import neo.setup.learn_center.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CardMapper extends GenericMapper<CardCreateDTO, CardUpdateDTO, CardGetDTO, CardDetailDTO, AuthCard> {
}
