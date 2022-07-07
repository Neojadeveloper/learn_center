package neo.setup.learn_center.mapper.auth.block_reason;

import neo.setup.learn_center.dto.auth.block_reason.BlockReasonCreateDTO;
import neo.setup.learn_center.dto.auth.block_reason.BlockReasonDetailDTO;
import neo.setup.learn_center.dto.auth.block_reason.BlockReasonGetDTO;
import neo.setup.learn_center.dto.auth.block_reason.BlockReasonUpdateDTO;
import neo.setup.learn_center.entity.auth.block_reason.AuthBlockReason;
import neo.setup.learn_center.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface BlockReasonMapper extends GenericMapper<BlockReasonCreateDTO, BlockReasonUpdateDTO, BlockReasonGetDTO, BlockReasonDetailDTO, AuthBlockReason> {
}
