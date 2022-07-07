package neo.setup.learn_center.service.system.skill;

import neo.setup.learn_center.criteria.system.skill.SkillCriteria;
import neo.setup.learn_center.dto.system.skill.SkillCreateDTO;
import neo.setup.learn_center.dto.system.skill.SkillDetailDTO;
import neo.setup.learn_center.dto.system.skill.SkillGetDTO;
import neo.setup.learn_center.dto.system.skill.SkillUpdateDTO;
import neo.setup.learn_center.service.GenericCUDService;
import neo.setup.learn_center.service.GenericGLDService;

import java.util.UUID;

public interface SkillService extends GenericCUDService<SkillCreateDTO, SkillUpdateDTO, UUID>, GenericGLDService<SkillGetDTO, SkillDetailDTO, SkillCriteria, UUID> {
}
