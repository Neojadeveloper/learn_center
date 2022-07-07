package neo.setup.learn_center.mapper.system.skill;

import neo.setup.learn_center.dto.system.skill.SkillCreateDTO;
import neo.setup.learn_center.dto.system.skill.SkillDetailDTO;
import neo.setup.learn_center.dto.system.skill.SkillGetDTO;
import neo.setup.learn_center.dto.system.skill.SkillUpdateDTO;
import neo.setup.learn_center.entity.system.skill.Skill;
import neo.setup.learn_center.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface SkillMapper extends GenericMapper<SkillCreateDTO, SkillUpdateDTO, SkillGetDTO, SkillDetailDTO, Skill> {
}
