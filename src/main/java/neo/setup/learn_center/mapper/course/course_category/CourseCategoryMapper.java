package neo.setup.learn_center.mapper.course.course_category;

import neo.setup.learn_center.dto.course.course_category.CourseCategoryCreateDTO;
import neo.setup.learn_center.dto.course.course_category.CourseCategoryDetailDTO;
import neo.setup.learn_center.dto.course.course_category.CourseCategoryGetDTO;
import neo.setup.learn_center.dto.course.course_category.CourseCategoryUpdateDTO;
import neo.setup.learn_center.entity.course.course_category.CourseCategory;
import neo.setup.learn_center.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CourseCategoryMapper extends GenericMapper<CourseCategoryCreateDTO, CourseCategoryUpdateDTO, CourseCategoryGetDTO, CourseCategoryDetailDTO, CourseCategory> {
}
