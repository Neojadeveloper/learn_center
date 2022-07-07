package neo.setup.learn_center.controller.course.course;

import neo.setup.learn_center.controller.AbstractController;
import neo.setup.learn_center.criteria.course.course.CourseCriteria;
import neo.setup.learn_center.dto.course.course.CourseCreateDTO;
import neo.setup.learn_center.dto.course.course.CourseDetailDTO;
import neo.setup.learn_center.dto.course.course.CourseGetDTO;
import neo.setup.learn_center.dto.course.course.CourseUpdateDTO;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.course.course.CourseServiceImpl;
import neo.setup.learn_center.utils.BaseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/course/*")
public class CourseControllerImpl extends AbstractController<CourseServiceImpl> implements CourseController {
    public CourseControllerImpl(CourseServiceImpl service) {
        super(service);
    }

    @Override
    public ResponseEntity<Data<String>> create(CourseCreateDTO DTO) {
        service.create(DTO);
        return new ResponseEntity<>(new Data<>("Successfully created - Course"), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Data<String>> update(CourseUpdateDTO DTO) {
        service.update(DTO);
        return new ResponseEntity<>(new Data<>("Successfully updated - Course"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<String>> delete(UUID code) {
        service.delete(code);
        return new ResponseEntity<>(new Data<>("Successfully deleted - Course"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<CourseGetDTO>> get(UUID code) {
        return service.get(code);
    }

    @Override
    public ResponseEntity<Data<CourseDetailDTO>> detail(UUID code) {
        return service.detail(code);
    }

    @Override
    public ResponseEntity<Data<List<CourseGetDTO>>> list(CourseCriteria criteria) {
        return service.list(criteria);
    }
}
