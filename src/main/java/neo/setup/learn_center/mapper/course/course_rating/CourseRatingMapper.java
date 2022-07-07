package neo.setup.learn_center.mapper.course.course_rating;

import neo.setup.learn_center.dto.course.course_rating.CourseRatingCreateDTO;
import neo.setup.learn_center.dto.course.course_rating.CourseRatingDetailDTO;
import neo.setup.learn_center.dto.course.course_rating.CourseRatingGetDTO;
import neo.setup.learn_center.dto.course.course_rating.CourseRatingUpdateDTO;
import neo.setup.learn_center.entity.course.course_rating.CourseRating;
import neo.setup.learn_center.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CourseRatingMapper extends GenericMapper<CourseRatingCreateDTO, CourseRatingUpdateDTO, CourseRatingGetDTO, CourseRatingDetailDTO, CourseRating> {
}
