package neo.setup.learn_center.service.course.course_video_source_code;

import neo.setup.learn_center.criteria.course.course_video_source_code.CourseVideoSourceCodeCriteria;
import neo.setup.learn_center.dto.course.course_video_source_code.CourseVideoSourceCodeCreateDTO;
import neo.setup.learn_center.dto.course.course_video_source_code.CourseVideoSourceCodeDetailDTO;
import neo.setup.learn_center.dto.course.course_video_source_code.CourseVideoSourceCodeGetDTO;
import neo.setup.learn_center.dto.course.course_video_source_code.CourseVideoSourceCodeUpdateDTO;
import neo.setup.learn_center.service.GenericCUDService;
import neo.setup.learn_center.service.GenericGLDService;

import java.util.UUID;

public interface CourseVideoSourceCodeService extends GenericCUDService<CourseVideoSourceCodeCreateDTO, CourseVideoSourceCodeUpdateDTO, UUID>, GenericGLDService<CourseVideoSourceCodeGetDTO, CourseVideoSourceCodeDetailDTO, CourseVideoSourceCodeCriteria, UUID> {
}
