package neo.setup.learn_center.service.course.course_video_materials;

import neo.setup.learn_center.criteria.course.course_video_materials.CourseVideoMaterialsCriteria;
import neo.setup.learn_center.dto.course.course_video_materials.CourseVideoMaterialsCreateDTO;
import neo.setup.learn_center.dto.course.course_video_materials.CourseVideoMaterialsDetailDTO;
import neo.setup.learn_center.dto.course.course_video_materials.CourseVideoMaterialsGetDTO;
import neo.setup.learn_center.dto.course.course_video_materials.CourseVideoMaterialsUpdateDTO;
import neo.setup.learn_center.service.GenericCUDService;
import neo.setup.learn_center.service.GenericGLDService;

import java.util.UUID;

public interface CourseVideoMaterialsService extends GenericCUDService<CourseVideoMaterialsCreateDTO, CourseVideoMaterialsUpdateDTO, UUID>, GenericGLDService<CourseVideoMaterialsGetDTO, CourseVideoMaterialsDetailDTO, CourseVideoMaterialsCriteria, UUID> {
}
