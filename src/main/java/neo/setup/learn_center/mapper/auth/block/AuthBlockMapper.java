package neo.setup.learn_center.mapper.auth.block;

import neo.setup.learn_center.dto.auth.block.AuthBlockCreateDDTO;
import neo.setup.learn_center.dto.auth.block.AuthBlockDetailDTO;
import neo.setup.learn_center.dto.auth.block.AuthBlockGetDTO;
import neo.setup.learn_center.dto.auth.block.AuthBlockUpdateDTO;
import neo.setup.learn_center.entity.auth.block.AuthBlock;
import neo.setup.learn_center.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AuthBlockMapper extends GenericMapper<AuthBlockCreateDDTO, AuthBlockUpdateDTO, AuthBlockGetDTO, AuthBlockDetailDTO, AuthBlock> {
}
