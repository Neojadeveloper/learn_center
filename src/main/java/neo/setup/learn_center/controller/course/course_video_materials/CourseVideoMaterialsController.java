package neo.setup.learn_center.controller.course.course_video_materials;

import neo.setup.learn_center.controller.GenericCUDController;
import neo.setup.learn_center.controller.GenericGLDController;
import neo.setup.learn_center.criteria.course.course_video_materials.CourseVideoMaterialsCriteria;
import neo.setup.learn_center.dto.course.course_video_materials.CourseVideoMaterialsCreateDTO;
import neo.setup.learn_center.dto.course.course_video_materials.CourseVideoMaterialsDetailDTO;
import neo.setup.learn_center.dto.course.course_video_materials.CourseVideoMaterialsGetDTO;
import neo.setup.learn_center.dto.course.course_video_materials.CourseVideoMaterialsUpdateDTO;

import java.util.UUID;

public interface CourseVideoMaterialsController extends GenericCUDController<CourseVideoMaterialsCreateDTO, CourseVideoMaterialsUpdateDTO, UUID>, GenericGLDController<CourseVideoMaterialsGetDTO, CourseVideoMaterialsDetailDTO, CourseVideoMaterialsCriteria, UUID> {
}
