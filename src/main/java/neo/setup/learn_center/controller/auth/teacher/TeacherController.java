package neo.setup.learn_center.controller.auth.teacher;

import neo.setup.learn_center.controller.GenericCUDController;
import neo.setup.learn_center.controller.GenericGLDController;
import neo.setup.learn_center.criteria.auth.teacher.TeacherCriteria;
import neo.setup.learn_center.dto.auth.teacher.TeacherCreateDTO;
import neo.setup.learn_center.dto.auth.teacher.TeacherDetailDTO;
import neo.setup.learn_center.dto.auth.teacher.TeacherGetDTO;
import neo.setup.learn_center.dto.auth.teacher.TeacherUpdateDTO;

import java.util.UUID;

public interface TeacherController extends GenericCUDController<TeacherCreateDTO, TeacherUpdateDTO, UUID>, GenericGLDController<TeacherGetDTO, TeacherDetailDTO, TeacherCriteria, UUID> {
}
