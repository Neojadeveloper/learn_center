package neo.setup.learn_center.service.course.course_category;

import neo.setup.learn_center.criteria.course.course_category.CourseCategoryCriteria;
import neo.setup.learn_center.dto.course.course_category.CourseCategoryCreateDTO;
import neo.setup.learn_center.dto.course.course_category.CourseCategoryDetailDTO;
import neo.setup.learn_center.dto.course.course_category.CourseCategoryGetDTO;
import neo.setup.learn_center.dto.course.course_category.CourseCategoryUpdateDTO;
import neo.setup.learn_center.service.GenericCUDService;
import neo.setup.learn_center.service.GenericGLDService;

import java.util.UUID;

public interface CourseCategoryService extends GenericCUDService<CourseCategoryCreateDTO, CourseCategoryUpdateDTO, UUID>, GenericGLDService<CourseCategoryGetDTO, CourseCategoryDetailDTO, CourseCategoryCriteria, UUID> {
}
