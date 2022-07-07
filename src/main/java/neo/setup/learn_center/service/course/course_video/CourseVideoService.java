package neo.setup.learn_center.service.course.course_video;

import neo.setup.learn_center.criteria.course.course_video.CourseVideoCriteria;
import neo.setup.learn_center.dto.course.course_video.CourseVideoCreateDTO;
import neo.setup.learn_center.dto.course.course_video.CourseVideoDetailDTO;
import neo.setup.learn_center.dto.course.course_video.CourseVideoGetDTO;
import neo.setup.learn_center.dto.course.course_video.CourseVideoUpdateDTO;
import neo.setup.learn_center.service.GenericCUDService;
import neo.setup.learn_center.service.GenericGLDService;

import java.util.UUID;

public interface CourseVideoService extends GenericCUDService<CourseVideoCreateDTO, CourseVideoUpdateDTO, UUID>, GenericGLDService<CourseVideoGetDTO, CourseVideoDetailDTO, CourseVideoCriteria, UUID> {
}
