package neo.setup.learn_center.mapper.course.course;

import neo.setup.learn_center.dto.course.course.CourseCreateDTO;
import neo.setup.learn_center.dto.course.course.CourseDetailDTO;
import neo.setup.learn_center.dto.course.course.CourseGetDTO;
import neo.setup.learn_center.dto.course.course.CourseUpdateDTO;
import neo.setup.learn_center.entity.course.course.Course;
import neo.setup.learn_center.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CourseMapper extends GenericMapper<CourseCreateDTO, CourseUpdateDTO, CourseGetDTO, CourseDetailDTO, Course> {
}
