package neo.setup.learn_center.mapper.auth.teacher_skills;

import neo.setup.learn_center.dto.auth.teacher_skills.TeacherSkillsCreateDTO;
import neo.setup.learn_center.dto.auth.teacher_skills.TeacherSkillsDetailDTO;
import neo.setup.learn_center.dto.auth.teacher_skills.TeacherSkillsGetDTO;
import neo.setup.learn_center.dto.auth.teacher_skills.TeacherSkillsUpdateDTO;
import neo.setup.learn_center.entity.auth.teacher_skills.TeacherSkills;
import neo.setup.learn_center.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface TeacherSkillsMapper extends GenericMapper<TeacherSkillsCreateDTO, TeacherSkillsUpdateDTO, TeacherSkillsGetDTO, TeacherSkillsDetailDTO, TeacherSkills> {
}
