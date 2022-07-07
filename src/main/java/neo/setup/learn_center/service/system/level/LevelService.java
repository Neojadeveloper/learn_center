package neo.setup.learn_center.service.system.level;

import neo.setup.learn_center.criteria.system.level.LevelCriteria;
import neo.setup.learn_center.dto.system.level.LevelCreateDTO;
import neo.setup.learn_center.dto.system.level.LevelDetailDTO;
import neo.setup.learn_center.dto.system.level.LevelGetDTO;
import neo.setup.learn_center.dto.system.level.LevelUpdateDTO;
import neo.setup.learn_center.service.GenericCUDService;
import neo.setup.learn_center.service.GenericGLDService;

import java.util.UUID;

public interface LevelService extends GenericCUDService<LevelCreateDTO, LevelUpdateDTO, UUID>, GenericGLDService<LevelGetDTO, LevelDetailDTO, LevelCriteria, UUID> {
}
