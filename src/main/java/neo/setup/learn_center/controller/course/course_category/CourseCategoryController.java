package neo.setup.learn_center.controller.course.course_category;

import neo.setup.learn_center.controller.GenericCUDController;
import neo.setup.learn_center.controller.GenericGLDController;
import neo.setup.learn_center.criteria.course.course_category.CourseCategoryCriteria;
import neo.setup.learn_center.dto.course.course_category.CourseCategoryCreateDTO;
import neo.setup.learn_center.dto.course.course_category.CourseCategoryDetailDTO;
import neo.setup.learn_center.dto.course.course_category.CourseCategoryGetDTO;
import neo.setup.learn_center.dto.course.course_category.CourseCategoryUpdateDTO;

import java.util.UUID;

public interface CourseCategoryController extends GenericCUDController<CourseCategoryCreateDTO, CourseCategoryUpdateDTO, UUID>, GenericGLDController<CourseCategoryGetDTO, CourseCategoryDetailDTO, CourseCategoryCriteria, UUID> {
}
