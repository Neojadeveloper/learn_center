package neo.setup.learn_center.controller.course.course_video_task;

import neo.setup.learn_center.controller.GenericCUDController;
import neo.setup.learn_center.controller.GenericGLDController;
import neo.setup.learn_center.criteria.course.course_video_task.CourseVideoTaskCriteria;
import neo.setup.learn_center.dto.course.course_video_task.CourseVideoTaskCreateDTO;
import neo.setup.learn_center.dto.course.course_video_task.CourseVideoTaskDetailDTO;
import neo.setup.learn_center.dto.course.course_video_task.CourseVideoTaskGetDTO;
import neo.setup.learn_center.dto.course.course_video_task.CourseVideoTaskUpdateDTO;

import java.util.UUID;

public interface CourseVideoTaskController extends GenericCUDController<CourseVideoTaskCreateDTO, CourseVideoTaskUpdateDTO, UUID>, GenericGLDController<CourseVideoTaskGetDTO, CourseVideoTaskDetailDTO, CourseVideoTaskCriteria, UUID> {
}
