package neo.setup.learn_center.controller.course.course_level;

import neo.setup.learn_center.controller.AbstractController;
import neo.setup.learn_center.criteria.course.course_level.CourseLevelCriteria;
import neo.setup.learn_center.dto.course.course_level.CourseLevelCreateDTO;
import neo.setup.learn_center.dto.course.course_level.CourseLevelDetailDTO;
import neo.setup.learn_center.dto.course.course_level.CourseLevelGetDTO;
import neo.setup.learn_center.dto.course.course_level.CourseLevelUpdateDTO;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.course.course_level.CourseLevelServiceImpl;
import neo.setup.learn_center.utils.BaseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/course-level/*")
public class CourseLevelControllerImpl extends AbstractController<CourseLevelServiceImpl> implements CourseLevelController {
    public CourseLevelControllerImpl(CourseLevelServiceImpl service) {
        super(service);
    }

    @Override
    public ResponseEntity<Data<String>> create(CourseLevelCreateDTO DTO) {
        service.create(DTO);
        return new ResponseEntity<>(new Data<>("Successfully created - Course Level"), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Data<String>> update(CourseLevelUpdateDTO DTO) {
        service.update(DTO);
        return new ResponseEntity<>(new Data<>("Successfully updated - Course Level"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<String>> delete(UUID code) {
        service.delete(code);
        return new ResponseEntity<>(new Data<>("Successfully deleted - Course Level"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<CourseLevelGetDTO>> get(UUID code) {
        return service.get(code);
    }

    @Override
    public ResponseEntity<Data<CourseLevelDetailDTO>> detail(UUID code) {
        return service.detail(code);
    }

    @Override
    public ResponseEntity<Data<List<CourseLevelGetDTO>>> list(CourseLevelCriteria criteria) {
        return service.list(criteria);
    }
}
