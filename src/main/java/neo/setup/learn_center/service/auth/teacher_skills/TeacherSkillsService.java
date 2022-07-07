package neo.setup.learn_center.service.auth.teacher_skills;

import neo.setup.learn_center.criteria.auth.teacher_skills.TeacherSkillsCriteria;
import neo.setup.learn_center.dto.auth.teacher_skills.TeacherSkillsCreateDTO;
import neo.setup.learn_center.dto.auth.teacher_skills.TeacherSkillsDetailDTO;
import neo.setup.learn_center.dto.auth.teacher_skills.TeacherSkillsGetDTO;
import neo.setup.learn_center.dto.auth.teacher_skills.TeacherSkillsUpdateDTO;
import neo.setup.learn_center.service.GenericCUDService;
import neo.setup.learn_center.service.GenericGLDService;

import java.util.UUID;

public interface TeacherSkillsService extends GenericCUDService<TeacherSkillsCreateDTO, TeacherSkillsUpdateDTO, UUID>, GenericGLDService<TeacherSkillsGetDTO, TeacherSkillsDetailDTO, TeacherSkillsCriteria, UUID> {
}
