package neo.setup.learn_center.service.auth.block_reason;

import neo.setup.learn_center.criteria.auth.block_reason.BlockReasonCriteria;
import neo.setup.learn_center.dto.auth.block_reason.BlockReasonCreateDTO;
import neo.setup.learn_center.dto.auth.block_reason.BlockReasonDetailDTO;
import neo.setup.learn_center.dto.auth.block_reason.BlockReasonGetDTO;
import neo.setup.learn_center.dto.auth.block_reason.BlockReasonUpdateDTO;
import neo.setup.learn_center.service.GenericCUDService;
import neo.setup.learn_center.service.GenericGLDService;

import java.util.UUID;

public interface BlockReasonService extends GenericCUDService<BlockReasonCreateDTO, BlockReasonUpdateDTO, UUID>, GenericGLDService<BlockReasonGetDTO, BlockReasonDetailDTO, BlockReasonCriteria, UUID> {
}
