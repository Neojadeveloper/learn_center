package neo.setup.learn_center.service.course.course_rating;

import neo.setup.learn_center.criteria.course.course_rating.CourseRatingCriteria;
import neo.setup.learn_center.dto.course.course_rating.CourseRatingCreateDTO;
import neo.setup.learn_center.dto.course.course_rating.CourseRatingDetailDTO;
import neo.setup.learn_center.dto.course.course_rating.CourseRatingGetDTO;
import neo.setup.learn_center.dto.course.course_rating.CourseRatingUpdateDTO;
import neo.setup.learn_center.service.GenericCUDService;
import neo.setup.learn_center.service.GenericGLDService;

import java.util.UUID;

public interface CourseRatingService extends GenericCUDService<CourseRatingCreateDTO, CourseRatingUpdateDTO, UUID>, GenericGLDService<CourseRatingGetDTO, CourseRatingDetailDTO, CourseRatingCriteria, UUID> {
}
