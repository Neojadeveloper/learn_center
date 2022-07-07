package neo.setup.learn_center.mapper.course.course_price;

import neo.setup.learn_center.dto.course.course_price.CoursePriceCreateDTO;
import neo.setup.learn_center.dto.course.course_price.CoursePriceDetailDTO;
import neo.setup.learn_center.dto.course.course_price.CoursePriceGetDTO;
import neo.setup.learn_center.dto.course.course_price.CoursePriceUpdateDTO;
import neo.setup.learn_center.entity.course.course_price.CoursePrice;
import neo.setup.learn_center.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CoursePriceMapper extends GenericMapper<CoursePriceCreateDTO, CoursePriceUpdateDTO, CoursePriceGetDTO, CoursePriceDetailDTO, CoursePrice> {
}
