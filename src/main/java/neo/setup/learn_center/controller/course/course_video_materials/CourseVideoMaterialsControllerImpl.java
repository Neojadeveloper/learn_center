package neo.setup.learn_center.controller.course.course_video_materials;

import neo.setup.learn_center.controller.AbstractController;
import neo.setup.learn_center.criteria.course.course_video_materials.CourseVideoMaterialsCriteria;
import neo.setup.learn_center.dto.course.course_video_materials.CourseVideoMaterialsCreateDTO;
import neo.setup.learn_center.dto.course.course_video_materials.CourseVideoMaterialsDetailDTO;
import neo.setup.learn_center.dto.course.course_video_materials.CourseVideoMaterialsGetDTO;
import neo.setup.learn_center.dto.course.course_video_materials.CourseVideoMaterialsUpdateDTO;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.course.course_video_materials.CourseVideoMaterialsServiceImpl;
import neo.setup.learn_center.utils.BaseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/course-video-materials/*")
public class CourseVideoMaterialsControllerImpl extends AbstractController<CourseVideoMaterialsServiceImpl> implements CourseVideoMaterialsController {
    public CourseVideoMaterialsControllerImpl(CourseVideoMaterialsServiceImpl service) {
        super(service);
    }

    @Override
    public ResponseEntity<Data<String>> create(CourseVideoMaterialsCreateDTO DTO) {
        service.create(DTO);
        return new ResponseEntity<>(new Data<>("Successfully created - Course Video Materials"), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Data<String>> update(CourseVideoMaterialsUpdateDTO DTO) {
        service.update(DTO);
        return new ResponseEntity<>(new Data<>("Successfully updated - Course Video Materials"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<String>> delete(UUID code) {
        service.delete(code);
        return new ResponseEntity<>(new Data<>("Successfully deleted - Course Video Materials"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<CourseVideoMaterialsGetDTO>> get(UUID code) {
        return service.get(code);
    }

    @Override
    public ResponseEntity<Data<CourseVideoMaterialsDetailDTO>> detail(UUID code) {
        return service.detail(code);
    }

    @Override
    public ResponseEntity<Data<List<CourseVideoMaterialsGetDTO>>> list(CourseVideoMaterialsCriteria criteria) {
        return service.list(criteria);
    }
}
