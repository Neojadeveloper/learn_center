package neo.setup.learn_center.controller.course.course_tag;

import neo.setup.learn_center.controller.GenericCUDController;
import neo.setup.learn_center.controller.GenericGLDController;
import neo.setup.learn_center.criteria.course.course_tag.CourseTagCriteria;
import neo.setup.learn_center.dto.course.course_tag.CourseTagCreateDTO;
import neo.setup.learn_center.dto.course.course_tag.CourseTagDetailDTO;
import neo.setup.learn_center.dto.course.course_tag.CourseTagGetDTO;
import neo.setup.learn_center.dto.course.course_tag.CourseTagUpdateDTO;

import java.util.UUID;

public interface CourseTagController extends GenericCUDController<CourseTagCreateDTO, CourseTagUpdateDTO, UUID>, GenericGLDController<CourseTagGetDTO, CourseTagDetailDTO, CourseTagCriteria, UUID> {
}
