package neo.setup.learn_center.service.course.course;

import neo.setup.learn_center.criteria.course.course.CourseCriteria;
import neo.setup.learn_center.dto.course.course.CourseCreateDTO;
import neo.setup.learn_center.dto.course.course.CourseDetailDTO;
import neo.setup.learn_center.dto.course.course.CourseGetDTO;
import neo.setup.learn_center.dto.course.course.CourseUpdateDTO;
import neo.setup.learn_center.service.GenericCUDService;
import neo.setup.learn_center.service.GenericGLDService;

import java.util.UUID;

public interface CourseService extends GenericCUDService<CourseCreateDTO, CourseUpdateDTO, UUID>, GenericGLDService<CourseGetDTO, CourseDetailDTO, CourseCriteria, UUID> {
}
