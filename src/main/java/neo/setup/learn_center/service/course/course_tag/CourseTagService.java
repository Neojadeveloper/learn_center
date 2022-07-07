package neo.setup.learn_center.service.course.course_tag;

import neo.setup.learn_center.criteria.course.course_tag.CourseTagCriteria;
import neo.setup.learn_center.dto.course.course_tag.CourseTagCreateDTO;
import neo.setup.learn_center.dto.course.course_tag.CourseTagDetailDTO;
import neo.setup.learn_center.dto.course.course_tag.CourseTagGetDTO;
import neo.setup.learn_center.dto.course.course_tag.CourseTagUpdateDTO;
import neo.setup.learn_center.service.GenericCUDService;
import neo.setup.learn_center.service.GenericGLDService;

import java.util.UUID;

public interface CourseTagService extends GenericCUDService<CourseTagCreateDTO, CourseTagUpdateDTO, UUID>, GenericGLDService<CourseTagGetDTO, CourseTagDetailDTO, CourseTagCriteria, UUID> {
}
