package neo.setup.learn_center.controller.course.course_rating;

import neo.setup.learn_center.controller.AbstractController;
import neo.setup.learn_center.criteria.course.course_rating.CourseRatingCriteria;
import neo.setup.learn_center.dto.course.course_rating.CourseRatingCreateDTO;
import neo.setup.learn_center.dto.course.course_rating.CourseRatingDetailDTO;
import neo.setup.learn_center.dto.course.course_rating.CourseRatingGetDTO;
import neo.setup.learn_center.dto.course.course_rating.CourseRatingUpdateDTO;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.course.course_rating.CourseRatingServiceImpl;
import neo.setup.learn_center.utils.BaseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/course-rating/*")
public class CourseRatingControllerImpl extends AbstractController<CourseRatingServiceImpl> implements CourseRatingController {
    public CourseRatingControllerImpl(CourseRatingServiceImpl service) {
        super(service);
    }

    @Override
    public ResponseEntity<Data<String>> create(CourseRatingCreateDTO DTO) {
        service.create(DTO);
        return new ResponseEntity<>(new Data<>("Successfully created - Course Rating"), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Data<String>> update(CourseRatingUpdateDTO DTO) {
        service.update(DTO);
        return new ResponseEntity<>(new Data<>("Successfully updated - Course Rating"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<String>> delete(UUID code) {
        service.delete(code);
        return new ResponseEntity<>(new Data<>("Successfully deleted - Course Rating"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<CourseRatingGetDTO>> get(UUID code) {
        return service.get(code);
    }

    @Override
    public ResponseEntity<Data<CourseRatingDetailDTO>> detail(UUID code) {
        return service.detail(code);
    }

    @Override
    public ResponseEntity<Data<List<CourseRatingGetDTO>>> list(CourseRatingCriteria criteria) {
        return service.list(criteria);
    }
}
