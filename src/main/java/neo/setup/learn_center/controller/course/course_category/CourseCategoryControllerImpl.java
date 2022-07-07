package neo.setup.learn_center.controller.course.course_category;

import neo.setup.learn_center.controller.AbstractController;
import neo.setup.learn_center.criteria.course.course_category.CourseCategoryCriteria;
import neo.setup.learn_center.dto.course.course_category.CourseCategoryCreateDTO;
import neo.setup.learn_center.dto.course.course_category.CourseCategoryDetailDTO;
import neo.setup.learn_center.dto.course.course_category.CourseCategoryGetDTO;
import neo.setup.learn_center.dto.course.course_category.CourseCategoryUpdateDTO;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.course.course_category.CourseCategoryServiceImpl;
import neo.setup.learn_center.utils.BaseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/course-category/*")
public class CourseCategoryControllerImpl extends AbstractController<CourseCategoryServiceImpl> implements CourseCategoryController {
    public CourseCategoryControllerImpl(CourseCategoryServiceImpl service) {
        super(service);
    }

    @Override
    public ResponseEntity<Data<String>> create(CourseCategoryCreateDTO DTO) {
        service.create(DTO);
        return new ResponseEntity<>(new Data<>("Successfully created - Course Category"), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Data<String>> update(CourseCategoryUpdateDTO DTO) {
        service.update(DTO);
        return new ResponseEntity<>(new Data<>("Successfully updated - Course Category"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<String>> delete(UUID code) {
        service.delete(code);
        return new ResponseEntity<>(new Data<>("Successfully deleted - Course Category"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<CourseCategoryGetDTO>> get(UUID code) {
        return service.get(code);
    }

    @Override
    public ResponseEntity<Data<CourseCategoryDetailDTO>> detail(UUID code) {
        return service.detail(code);
    }

    @Override
    public ResponseEntity<Data<List<CourseCategoryGetDTO>>> list(CourseCategoryCriteria criteria) {
        return service.list(criteria);
    }
}
