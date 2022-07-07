package neo.setup.learn_center.service.course.course_price;

import neo.setup.learn_center.criteria.course.course_price.CoursePriceCriteria;
import neo.setup.learn_center.dto.course.course_price.CoursePriceCreateDTO;
import neo.setup.learn_center.dto.course.course_price.CoursePriceDetailDTO;
import neo.setup.learn_center.dto.course.course_price.CoursePriceGetDTO;
import neo.setup.learn_center.dto.course.course_price.CoursePriceUpdateDTO;
import neo.setup.learn_center.service.GenericCUDService;
import neo.setup.learn_center.service.GenericGLDService;

import java.util.UUID;

public interface CoursePriceService extends GenericCUDService<CoursePriceCreateDTO, CoursePriceUpdateDTO, UUID>, GenericGLDService<CoursePriceGetDTO, CoursePriceDetailDTO, CoursePriceCriteria, UUID> {
}
