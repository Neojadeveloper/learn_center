package neo.setup.learn_center.controller.course.course;

import neo.setup.learn_center.controller.GenericCUDController;
import neo.setup.learn_center.controller.GenericGLDController;
import neo.setup.learn_center.criteria.course.course.CourseCriteria;
import neo.setup.learn_center.dto.course.course.CourseCreateDTO;
import neo.setup.learn_center.dto.course.course.CourseDetailDTO;
import neo.setup.learn_center.dto.course.course.CourseGetDTO;
import neo.setup.learn_center.dto.course.course.CourseUpdateDTO;

import java.util.UUID;

public interface CourseController extends GenericCUDController<CourseCreateDTO, CourseUpdateDTO, UUID>, GenericGLDController<CourseGetDTO, CourseDetailDTO, CourseCriteria, UUID> {
}
