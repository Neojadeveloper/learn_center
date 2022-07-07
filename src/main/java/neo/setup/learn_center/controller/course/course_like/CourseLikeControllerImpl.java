package neo.setup.learn_center.controller.course.course_like;

import neo.setup.learn_center.controller.AbstractController;
import neo.setup.learn_center.criteria.course.course_like.CourseLikeCriteria;
import neo.setup.learn_center.dto.course.course_like.CourseLikeCreateDTO;
import neo.setup.learn_center.dto.course.course_like.CourseLikeDetailDTO;
import neo.setup.learn_center.dto.course.course_like.CourseLikeGetDTO;
import neo.setup.learn_center.dto.course.course_like.CourseLikeUpdateDTO;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.course.course_like.CourseLikeServiceImpl;
import neo.setup.learn_center.utils.BaseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/course-like/*")
public class CourseLikeControllerImpl extends AbstractController<CourseLikeServiceImpl> implements CourseLikeController {
    public CourseLikeControllerImpl(CourseLikeServiceImpl service) {
        super(service);
    }

    @Override
    public ResponseEntity<Data<String>> create(CourseLikeCreateDTO DTO) {
        service.create(DTO);
        return new ResponseEntity<>(new Data<>("Successfully created - Course Like"), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Data<String>> update(CourseLikeUpdateDTO DTO) {
        service.update(DTO);
        return new ResponseEntity<>(new Data<>("Successfully updated - Course Like"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<String>> delete(UUID code) {
        service.delete(code);
        return new ResponseEntity<>(new Data<>("Successfully deleted - Course Like"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<CourseLikeGetDTO>> get(UUID code) {
        return service.get(code);
    }

    @Override
    public ResponseEntity<Data<CourseLikeDetailDTO>> detail(UUID code) {
        return service.detail(code);
    }

    @Override
    public ResponseEntity<Data<List<CourseLikeGetDTO>>> list(CourseLikeCriteria criteria) {
        return service.list(criteria);
    }
}
