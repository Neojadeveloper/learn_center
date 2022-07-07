package neo.setup.learn_center.service.course.course_video_task;

import neo.setup.learn_center.criteria.course.course_video_task.CourseVideoTaskCriteria;
import neo.setup.learn_center.dto.course.course_video_task.CourseVideoTaskCreateDTO;
import neo.setup.learn_center.dto.course.course_video_task.CourseVideoTaskDetailDTO;
import neo.setup.learn_center.dto.course.course_video_task.CourseVideoTaskGetDTO;
import neo.setup.learn_center.dto.course.course_video_task.CourseVideoTaskUpdateDTO;
import neo.setup.learn_center.service.GenericCUDService;
import neo.setup.learn_center.service.GenericGLDService;

import java.util.UUID;

public interface CourseVideoTaskService extends GenericCUDService<CourseVideoTaskCreateDTO, CourseVideoTaskUpdateDTO, UUID>, GenericGLDService<CourseVideoTaskGetDTO, CourseVideoTaskDetailDTO, CourseVideoTaskCriteria, UUID> {
}
