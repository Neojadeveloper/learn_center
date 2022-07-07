package neo.setup.learn_center.controller.system.level;

import neo.setup.learn_center.controller.GenericCUDController;
import neo.setup.learn_center.controller.GenericGLDController;
import neo.setup.learn_center.criteria.system.level.LevelCriteria;
import neo.setup.learn_center.dto.system.level.LevelCreateDTO;
import neo.setup.learn_center.dto.system.level.LevelDetailDTO;
import neo.setup.learn_center.dto.system.level.LevelGetDTO;
import neo.setup.learn_center.dto.system.level.LevelUpdateDTO;

import java.util.UUID;

public interface LevelController extends GenericCUDController<LevelCreateDTO, LevelUpdateDTO, UUID>, GenericGLDController<LevelGetDTO, LevelDetailDTO, LevelCriteria, UUID> {
}
