package neo.setup.learn_center.controller.auth.block_reason;

import neo.setup.learn_center.controller.GenericCUDController;
import neo.setup.learn_center.controller.GenericGLDController;
import neo.setup.learn_center.criteria.auth.block_reason.BlockReasonCriteria;
import neo.setup.learn_center.dto.auth.block_reason.BlockReasonCreateDTO;
import neo.setup.learn_center.dto.auth.block_reason.BlockReasonDetailDTO;
import neo.setup.learn_center.dto.auth.block_reason.BlockReasonGetDTO;
import neo.setup.learn_center.dto.auth.block_reason.BlockReasonUpdateDTO;

import java.util.UUID;

public interface BlockReasonController extends GenericCUDController<BlockReasonCreateDTO, BlockReasonUpdateDTO, UUID>, GenericGLDController<BlockReasonGetDTO, BlockReasonDetailDTO, BlockReasonCriteria, UUID> {
}
