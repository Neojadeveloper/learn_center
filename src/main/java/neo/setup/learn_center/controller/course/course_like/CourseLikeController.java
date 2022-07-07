package neo.setup.learn_center.controller.course.course_like;

import neo.setup.learn_center.controller.GenericCUDController;
import neo.setup.learn_center.controller.GenericGLDController;
import neo.setup.learn_center.criteria.course.course_like.CourseLikeCriteria;
import neo.setup.learn_center.dto.course.course_like.CourseLikeCreateDTO;
import neo.setup.learn_center.dto.course.course_like.CourseLikeDetailDTO;
import neo.setup.learn_center.dto.course.course_like.CourseLikeGetDTO;
import neo.setup.learn_center.dto.course.course_like.CourseLikeUpdateDTO;

import java.util.UUID;

public interface CourseLikeController extends GenericCUDController<CourseLikeCreateDTO, CourseLikeUpdateDTO, UUID>, GenericGLDController<CourseLikeGetDTO, CourseLikeDetailDTO, CourseLikeCriteria, UUID> {
}
