package neo.setup.learn_center.controller.course.course_video_source_code;

import neo.setup.learn_center.controller.GenericCUDController;
import neo.setup.learn_center.controller.GenericGLDController;
import neo.setup.learn_center.criteria.course.course_video_source_code.CourseVideoSourceCodeCriteria;
import neo.setup.learn_center.dto.course.course_video_source_code.CourseVideoSourceCodeCreateDTO;
import neo.setup.learn_center.dto.course.course_video_source_code.CourseVideoSourceCodeDetailDTO;
import neo.setup.learn_center.dto.course.course_video_source_code.CourseVideoSourceCodeGetDTO;
import neo.setup.learn_center.dto.course.course_video_source_code.CourseVideoSourceCodeUpdateDTO;

import java.util.UUID;

public interface CourseVideoSourceCodeController extends GenericCUDController<CourseVideoSourceCodeCreateDTO, CourseVideoSourceCodeUpdateDTO, UUID>, GenericGLDController<CourseVideoSourceCodeGetDTO, CourseVideoSourceCodeDetailDTO, CourseVideoSourceCodeCriteria, UUID> {
}
