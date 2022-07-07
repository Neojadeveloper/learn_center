package neo.setup.learn_center.controller.auth.block;

import neo.setup.learn_center.controller.GenericCUDController;
import neo.setup.learn_center.controller.GenericGLDController;
import neo.setup.learn_center.criteria.auth.block.AuthBlockCriteria;
import neo.setup.learn_center.dto.auth.block.AuthBlockCreateDDTO;
import neo.setup.learn_center.dto.auth.block.AuthBlockDetailDTO;
import neo.setup.learn_center.dto.auth.block.AuthBlockGetDTO;
import neo.setup.learn_center.dto.auth.block.AuthBlockUpdateDTO;

import java.util.UUID;

public interface AuthBlockController extends GenericCUDController<AuthBlockCreateDDTO, AuthBlockUpdateDTO, UUID>, GenericGLDController<AuthBlockGetDTO, AuthBlockDetailDTO, AuthBlockCriteria, UUID> {
}
