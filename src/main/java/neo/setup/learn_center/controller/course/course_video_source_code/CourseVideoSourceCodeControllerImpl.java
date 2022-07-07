package neo.setup.learn_center.controller.course.course_video_source_code;

import neo.setup.learn_center.controller.AbstractController;
import neo.setup.learn_center.criteria.course.course_video_source_code.CourseVideoSourceCodeCriteria;
import neo.setup.learn_center.dto.course.course_video_source_code.CourseVideoSourceCodeCreateDTO;
import neo.setup.learn_center.dto.course.course_video_source_code.CourseVideoSourceCodeDetailDTO;
import neo.setup.learn_center.dto.course.course_video_source_code.CourseVideoSourceCodeGetDTO;
import neo.setup.learn_center.dto.course.course_video_source_code.CourseVideoSourceCodeUpdateDTO;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.course.course_video_source_code.CourseVideoSourceCodeServiceImpl;
import neo.setup.learn_center.utils.BaseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/course-video-source-code/*")
public class CourseVideoSourceCodeControllerImpl extends AbstractController<CourseVideoSourceCodeServiceImpl> implements CourseVideoSourceCodeController {
    public CourseVideoSourceCodeControllerImpl(CourseVideoSourceCodeServiceImpl service) {
        super(service);
    }

    @Override
    public ResponseEntity<Data<String>> create(CourseVideoSourceCodeCreateDTO DTO) {
        service.create(DTO);
        return new ResponseEntity<>(new Data<>("Successfully created - Course Video Source Code"), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Data<String>> update(CourseVideoSourceCodeUpdateDTO DTO) {
        service.update(DTO);
        return new ResponseEntity<>(new Data<>("Successfully updated - Course Video Source Code"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<String>> delete(UUID code) {
        service.delete(code);
        return new ResponseEntity<>(new Data<>("Successfully deleted - Course Video Source Code"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<CourseVideoSourceCodeGetDTO>> get(UUID code) {
        return service.get(code);
    }

    @Override
    public ResponseEntity<Data<CourseVideoSourceCodeDetailDTO>> detail(UUID code) {
        return service.detail(code);
    }

    @Override
    public ResponseEntity<Data<List<CourseVideoSourceCodeGetDTO>>> list(CourseVideoSourceCodeCriteria criteria) {
        return service.list(criteria);
    }
}
