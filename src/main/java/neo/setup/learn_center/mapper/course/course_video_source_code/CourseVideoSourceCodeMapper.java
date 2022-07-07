package neo.setup.learn_center.mapper.course.course_video_source_code;

import neo.setup.learn_center.dto.course.course_video_source_code.CourseVideoSourceCodeCreateDTO;
import neo.setup.learn_center.dto.course.course_video_source_code.CourseVideoSourceCodeDetailDTO;
import neo.setup.learn_center.dto.course.course_video_source_code.CourseVideoSourceCodeGetDTO;
import neo.setup.learn_center.dto.course.course_video_source_code.CourseVideoSourceCodeUpdateDTO;
import neo.setup.learn_center.entity.course.course_video_source_code.CourseVideoSourceCode;
import neo.setup.learn_center.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CourseVideoSourceCodeMapper extends GenericMapper<CourseVideoSourceCodeCreateDTO, CourseVideoSourceCodeUpdateDTO, CourseVideoSourceCodeGetDTO, CourseVideoSourceCodeDetailDTO, CourseVideoSourceCode> {
}
