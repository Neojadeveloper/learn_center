package neo.setup.learn_center.controller.auth.status;

import neo.setup.learn_center.controller.GenericCUDController;
import neo.setup.learn_center.controller.GenericGLDController;
import neo.setup.learn_center.criteria.auth.status.StatusCriteria;
import neo.setup.learn_center.dto.auth.status.StatusCreateDTO;
import neo.setup.learn_center.dto.auth.status.StatusDetailDTO;
import neo.setup.learn_center.dto.auth.status.StatusGetDTO;
import neo.setup.learn_center.dto.auth.status.StatusUpdateDTO;

import java.util.UUID;

public interface StatusController extends GenericCUDController<StatusCreateDTO, StatusUpdateDTO, UUID>, GenericGLDController<StatusGetDTO, StatusDetailDTO, StatusCriteria, UUID> {
}
