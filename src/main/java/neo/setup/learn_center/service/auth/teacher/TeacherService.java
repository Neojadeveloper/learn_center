package neo.setup.learn_center.service.auth.teacher;

import neo.setup.learn_center.criteria.auth.teacher.TeacherCriteria;
import neo.setup.learn_center.dto.auth.teacher.TeacherCreateDTO;
import neo.setup.learn_center.dto.auth.teacher.TeacherDetailDTO;
import neo.setup.learn_center.dto.auth.teacher.TeacherGetDTO;
import neo.setup.learn_center.dto.auth.teacher.TeacherUpdateDTO;
import neo.setup.learn_center.service.GenericCUDService;
import neo.setup.learn_center.service.GenericGLDService;

import java.util.UUID;

public interface TeacherService extends GenericCUDService<TeacherCreateDTO, TeacherUpdateDTO, UUID>, GenericGLDService<TeacherGetDTO, TeacherDetailDTO, TeacherCriteria, UUID> {
}
