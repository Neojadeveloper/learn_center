package neo.setup.learn_center.controller.course.course_price;

import neo.setup.learn_center.controller.AbstractController;
import neo.setup.learn_center.criteria.course.course_price.CoursePriceCriteria;
import neo.setup.learn_center.dto.course.course_price.CoursePriceCreateDTO;
import neo.setup.learn_center.dto.course.course_price.CoursePriceDetailDTO;
import neo.setup.learn_center.dto.course.course_price.CoursePriceGetDTO;
import neo.setup.learn_center.dto.course.course_price.CoursePriceUpdateDTO;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.course.course_price.CoursePriceServiceImpl;
import neo.setup.learn_center.utils.BaseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/course-price/*")
public class CoursePriceControllerImpl extends AbstractController<CoursePriceServiceImpl> implements CoursePriceController {
    public CoursePriceControllerImpl(CoursePriceServiceImpl service) {
        super(service);
    }

    @Override
    public ResponseEntity<Data<String>> create(CoursePriceCreateDTO DTO) {
        service.create(DTO);
        return new ResponseEntity<>(new Data<>("Successfully created - Course Price"), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Data<String>> update(CoursePriceUpdateDTO DTO) {
        service.update(DTO);
        return new ResponseEntity<>(new Data<>("Successfully updated - Course Price"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<String>> delete(UUID code) {
        service.delete(code);
        return new ResponseEntity<>(new Data<>("Successfully deleted - Course Price"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<CoursePriceGetDTO>> get(UUID code) {
        return service.get(code);
    }

    @Override
    public ResponseEntity<Data<CoursePriceDetailDTO>> detail(UUID code) {
        return service.detail(code);
    }

    @Override
    public ResponseEntity<Data<List<CoursePriceGetDTO>>> list(CoursePriceCriteria criteria) {
        return service.list(criteria);
    }
}
