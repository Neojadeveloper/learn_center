package neo.setup.learn_center.service.course.course_level;

import neo.setup.learn_center.criteria.course.course_level.CourseLevelCriteria;
import neo.setup.learn_center.dto.course.course_level.CourseLevelCreateDTO;
import neo.setup.learn_center.dto.course.course_level.CourseLevelDetailDTO;
import neo.setup.learn_center.dto.course.course_level.CourseLevelGetDTO;
import neo.setup.learn_center.dto.course.course_level.CourseLevelUpdateDTO;
import neo.setup.learn_center.service.GenericCUDService;
import neo.setup.learn_center.service.GenericGLDService;

import java.util.UUID;

public interface CourseLevelService extends GenericCUDService<CourseLevelCreateDTO, CourseLevelUpdateDTO, UUID>, GenericGLDService<CourseLevelGetDTO, CourseLevelDetailDTO, CourseLevelCriteria, UUID> {
}
