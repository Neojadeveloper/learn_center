package neo.setup.learn_center.service.course.course_like;

import neo.setup.learn_center.criteria.course.course_like.CourseLikeCriteria;
import neo.setup.learn_center.dto.course.course_like.CourseLikeCreateDTO;
import neo.setup.learn_center.dto.course.course_like.CourseLikeDetailDTO;
import neo.setup.learn_center.dto.course.course_like.CourseLikeGetDTO;
import neo.setup.learn_center.dto.course.course_like.CourseLikeUpdateDTO;
import neo.setup.learn_center.service.GenericCUDService;
import neo.setup.learn_center.service.GenericGLDService;

import java.util.UUID;

public interface CourseLikeService extends GenericCUDService<CourseLikeCreateDTO, CourseLikeUpdateDTO, UUID>, GenericGLDService<CourseLikeGetDTO, CourseLikeDetailDTO, CourseLikeCriteria, UUID> {
}
