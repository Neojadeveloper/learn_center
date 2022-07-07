package neo.setup.learn_center.controller.course.course_tag;

import neo.setup.learn_center.controller.AbstractController;
import neo.setup.learn_center.criteria.course.course_tag.CourseTagCriteria;
import neo.setup.learn_center.dto.course.course_tag.CourseTagCreateDTO;
import neo.setup.learn_center.dto.course.course_tag.CourseTagDetailDTO;
import neo.setup.learn_center.dto.course.course_tag.CourseTagGetDTO;
import neo.setup.learn_center.dto.course.course_tag.CourseTagUpdateDTO;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.course.course_tag.CourseTagServiceImpl;
import neo.setup.learn_center.utils.BaseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/course-tag/*")
public class CourseTagControllerImpl extends AbstractController<CourseTagServiceImpl> implements CourseTagController {
    public CourseTagControllerImpl(CourseTagServiceImpl service) {
        super(service);
    }

    @Override
    public ResponseEntity<Data<String>> create(CourseTagCreateDTO DTO) {
        service.create(DTO);
        return new ResponseEntity<>(new Data<>("Successfully created - Course Tag"), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Data<String>> update(CourseTagUpdateDTO DTO) {
        service.update(DTO);
        return new ResponseEntity<>(new Data<>("Successfully updated - Course Tag"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<String>> delete(UUID code) {
        service.delete(code);
        return new ResponseEntity<>(new Data<>("Successfully deleted - Course Tag"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<CourseTagGetDTO>> get(UUID code) {
        return service.get(code);
    }

    @Override
    public ResponseEntity<Data<CourseTagDetailDTO>> detail(UUID code) {
        return service.detail(code);
    }

    @Override
    public ResponseEntity<Data<List<CourseTagGetDTO>>> list(CourseTagCriteria criteria) {
        return service.list(criteria);
    }
}
