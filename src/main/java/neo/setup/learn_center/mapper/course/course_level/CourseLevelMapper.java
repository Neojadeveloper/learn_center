package neo.setup.learn_center.mapper.course.course_level;

import neo.setup.learn_center.dto.course.course_level.CourseLevelCreateDTO;
import neo.setup.learn_center.dto.course.course_level.CourseLevelDetailDTO;
import neo.setup.learn_center.dto.course.course_level.CourseLevelGetDTO;
import neo.setup.learn_center.dto.course.course_level.CourseLevelUpdateDTO;
import neo.setup.learn_center.entity.course.course_level.CourseLevel;
import neo.setup.learn_center.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CourseLevelMapper extends GenericMapper<CourseLevelCreateDTO, CourseLevelUpdateDTO, CourseLevelGetDTO, CourseLevelDetailDTO, CourseLevel> {
}
