package neo.setup.learn_center.controller.course.course_price;

import neo.setup.learn_center.controller.GenericCUDController;
import neo.setup.learn_center.controller.GenericGLDController;
import neo.setup.learn_center.criteria.course.course_price.CoursePriceCriteria;
import neo.setup.learn_center.dto.course.course_price.CoursePriceCreateDTO;
import neo.setup.learn_center.dto.course.course_price.CoursePriceDetailDTO;
import neo.setup.learn_center.dto.course.course_price.CoursePriceGetDTO;
import neo.setup.learn_center.dto.course.course_price.CoursePriceUpdateDTO;

import java.util.UUID;

public interface CoursePriceController extends GenericCUDController<CoursePriceCreateDTO, CoursePriceUpdateDTO, UUID>, GenericGLDController<CoursePriceGetDTO, CoursePriceDetailDTO, CoursePriceCriteria, UUID> {
}
