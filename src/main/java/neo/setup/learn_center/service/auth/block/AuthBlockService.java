package neo.setup.learn_center.service.auth.block;

import neo.setup.learn_center.criteria.auth.block.AuthBlockCriteria;
import neo.setup.learn_center.dto.auth.block.AuthBlockCreateDDTO;
import neo.setup.learn_center.dto.auth.block.AuthBlockDetailDTO;
import neo.setup.learn_center.dto.auth.block.AuthBlockGetDTO;
import neo.setup.learn_center.dto.auth.block.AuthBlockUpdateDTO;
import neo.setup.learn_center.service.GenericCUDService;
import neo.setup.learn_center.service.GenericGLDService;

import java.util.UUID;

public interface AuthBlockService extends GenericCUDService<AuthBlockCreateDDTO, AuthBlockUpdateDTO, UUID>, GenericGLDService<AuthBlockGetDTO, AuthBlockDetailDTO, AuthBlockCriteria, UUID> {
}
