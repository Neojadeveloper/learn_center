package neo.setup.learn_center.controller.course.course_video;

import neo.setup.learn_center.controller.GenericCUDController;
import neo.setup.learn_center.controller.GenericGLDController;
import neo.setup.learn_center.criteria.course.course_video.CourseVideoCriteria;
import neo.setup.learn_center.dto.course.course_video.CourseVideoCreateDTO;
import neo.setup.learn_center.dto.course.course_video.CourseVideoDetailDTO;
import neo.setup.learn_center.dto.course.course_video.CourseVideoGetDTO;
import neo.setup.learn_center.dto.course.course_video.CourseVideoUpdateDTO;

import java.util.UUID;

public interface CourseVideoController extends GenericCUDController<CourseVideoCreateDTO, CourseVideoUpdateDTO, UUID>, GenericGLDController<CourseVideoGetDTO, CourseVideoDetailDTO, CourseVideoCriteria, UUID> {
}
