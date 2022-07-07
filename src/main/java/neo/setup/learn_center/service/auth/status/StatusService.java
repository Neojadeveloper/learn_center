package neo.setup.learn_center.service.auth.status;

import neo.setup.learn_center.criteria.auth.status.StatusCriteria;
import neo.setup.learn_center.dto.auth.status.StatusCreateDTO;
import neo.setup.learn_center.dto.auth.status.StatusDetailDTO;
import neo.setup.learn_center.dto.auth.status.StatusGetDTO;
import neo.setup.learn_center.dto.auth.status.StatusUpdateDTO;
import neo.setup.learn_center.service.GenericCUDService;
import neo.setup.learn_center.service.GenericGLDService;

import java.util.UUID;

public interface StatusService extends GenericCUDService<StatusCreateDTO, StatusUpdateDTO, UUID>, GenericGLDService<StatusGetDTO, StatusDetailDTO, StatusCriteria, UUID> {
}
