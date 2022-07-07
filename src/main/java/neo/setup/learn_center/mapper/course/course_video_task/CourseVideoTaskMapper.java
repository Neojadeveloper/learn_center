package neo.setup.learn_center.mapper.course.course_video_task;

import neo.setup.learn_center.dto.course.course_video_task.CourseVideoTaskCreateDTO;
import neo.setup.learn_center.dto.course.course_video_task.CourseVideoTaskDetailDTO;
import neo.setup.learn_center.dto.course.course_video_task.CourseVideoTaskGetDTO;
import neo.setup.learn_center.dto.course.course_video_task.CourseVideoTaskUpdateDTO;
import neo.setup.learn_center.entity.course.course_video_task.CourseVideoTask;
import neo.setup.learn_center.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CourseVideoTaskMapper extends GenericMapper<CourseVideoTaskCreateDTO, CourseVideoTaskUpdateDTO, CourseVideoTaskGetDTO, CourseVideoTaskDetailDTO, CourseVideoTask> {
}
