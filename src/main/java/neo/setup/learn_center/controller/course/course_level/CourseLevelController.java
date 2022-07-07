package neo.setup.learn_center.controller.course.course_level;

import neo.setup.learn_center.controller.GenericCUDController;
import neo.setup.learn_center.controller.GenericGLDController;
import neo.setup.learn_center.criteria.course.course_level.CourseLevelCriteria;
import neo.setup.learn_center.dto.course.course_level.CourseLevelCreateDTO;
import neo.setup.learn_center.dto.course.course_level.CourseLevelDetailDTO;
import neo.setup.learn_center.dto.course.course_level.CourseLevelGetDTO;
import neo.setup.learn_center.dto.course.course_level.CourseLevelUpdateDTO;

import java.util.UUID;

public interface CourseLevelController extends GenericCUDController<CourseLevelCreateDTO, CourseLevelUpdateDTO, UUID>, GenericGLDController<CourseLevelGetDTO, CourseLevelDetailDTO, CourseLevelCriteria, UUID> {
}
