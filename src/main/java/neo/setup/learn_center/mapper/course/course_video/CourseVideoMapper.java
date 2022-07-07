package neo.setup.learn_center.mapper.course.course_video;

import neo.setup.learn_center.dto.course.course_video.CourseVideoCreateDTO;
import neo.setup.learn_center.dto.course.course_video.CourseVideoDetailDTO;
import neo.setup.learn_center.dto.course.course_video.CourseVideoGetDTO;
import neo.setup.learn_center.dto.course.course_video.CourseVideoUpdateDTO;
import neo.setup.learn_center.entity.course.course_video.CourseVideo;
import neo.setup.learn_center.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CourseVideoMapper extends GenericMapper<CourseVideoCreateDTO, CourseVideoUpdateDTO, CourseVideoGetDTO, CourseVideoDetailDTO, CourseVideo> {
}
