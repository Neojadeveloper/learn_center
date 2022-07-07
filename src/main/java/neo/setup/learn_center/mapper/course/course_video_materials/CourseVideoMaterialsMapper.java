package neo.setup.learn_center.mapper.course.course_video_materials;

import neo.setup.learn_center.dto.course.course_video_materials.CourseVideoMaterialsCreateDTO;
import neo.setup.learn_center.dto.course.course_video_materials.CourseVideoMaterialsDetailDTO;
import neo.setup.learn_center.dto.course.course_video_materials.CourseVideoMaterialsGetDTO;
import neo.setup.learn_center.dto.course.course_video_materials.CourseVideoMaterialsUpdateDTO;
import neo.setup.learn_center.entity.course.course_video_materials.CourseVideoMaterials;
import neo.setup.learn_center.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CourseVideoMaterialsMapper extends GenericMapper<CourseVideoMaterialsCreateDTO, CourseVideoMaterialsUpdateDTO, CourseVideoMaterialsGetDTO, CourseVideoMaterialsDetailDTO, CourseVideoMaterials> {
}
