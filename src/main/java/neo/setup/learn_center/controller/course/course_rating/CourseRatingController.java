package neo.setup.learn_center.controller.course.course_rating;

import neo.setup.learn_center.controller.GenericCUDController;
import neo.setup.learn_center.controller.GenericGLDController;
import neo.setup.learn_center.criteria.course.course_rating.CourseRatingCriteria;
import neo.setup.learn_center.dto.course.course_rating.CourseRatingCreateDTO;
import neo.setup.learn_center.dto.course.course_rating.CourseRatingDetailDTO;
import neo.setup.learn_center.dto.course.course_rating.CourseRatingGetDTO;
import neo.setup.learn_center.dto.course.course_rating.CourseRatingUpdateDTO;

import java.util.UUID;

public interface CourseRatingController extends GenericCUDController<CourseRatingCreateDTO, CourseRatingUpdateDTO, UUID>, GenericGLDController<CourseRatingGetDTO, CourseRatingDetailDTO, CourseRatingCriteria, UUID> {
}
