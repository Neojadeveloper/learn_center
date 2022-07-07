package neo.setup.learn_center.mapper.auth.card_type;

import neo.setup.learn_center.dto.auth.card_type.CardTypeCreateDTO;
import neo.setup.learn_center.dto.auth.card_type.CardTypeDetailDTO;
import neo.setup.learn_center.dto.auth.card_type.CardTypeGetDTO;
import neo.setup.learn_center.dto.auth.card_type.CardTypeUpdateDTO;
import neo.setup.learn_center.entity.auth.card_type.AuthCardType;
import neo.setup.learn_center.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CardTypeMapper extends GenericMapper<CardTypeCreateDTO, CardTypeUpdateDTO, CardTypeGetDTO, CardTypeDetailDTO, AuthCardType> {
}
