package neo.setup.learn_center.controller.system.skill;

import neo.setup.learn_center.controller.GenericCUDController;
import neo.setup.learn_center.controller.GenericGLDController;
import neo.setup.learn_center.criteria.system.skill.SkillCriteria;
import neo.setup.learn_center.dto.system.skill.SkillCreateDTO;
import neo.setup.learn_center.dto.system.skill.SkillDetailDTO;
import neo.setup.learn_center.dto.system.skill.SkillGetDTO;
import neo.setup.learn_center.dto.system.skill.SkillUpdateDTO;

import java.util.UUID;

public interface SkillController extends GenericCUDController<SkillCreateDTO, SkillUpdateDTO, UUID>, GenericGLDController<SkillGetDTO, SkillDetailDTO, SkillCriteria, UUID> {
}
