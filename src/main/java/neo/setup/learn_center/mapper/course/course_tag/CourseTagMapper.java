package neo.setup.learn_center.mapper.course.course_tag;

import neo.setup.learn_center.dto.course.course_tag.CourseTagCreateDTO;
import neo.setup.learn_center.dto.course.course_tag.CourseTagDetailDTO;
import neo.setup.learn_center.dto.course.course_tag.CourseTagGetDTO;
import neo.setup.learn_center.dto.course.course_tag.CourseTagUpdateDTO;
import neo.setup.learn_center.entity.course.course_tag.CourseTag;
import neo.setup.learn_center.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CourseTagMapper extends GenericMapper<CourseTagCreateDTO, CourseTagUpdateDTO, CourseTagGetDTO, CourseTagDetailDTO, CourseTag> {
}
