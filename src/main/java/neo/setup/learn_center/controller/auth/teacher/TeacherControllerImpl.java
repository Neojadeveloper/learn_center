package neo.setup.learn_center.controller.auth.teacher;

import neo.setup.learn_center.controller.AbstractController;
import neo.setup.learn_center.criteria.auth.teacher.TeacherCriteria;
import neo.setup.learn_center.dto.auth.teacher.TeacherCreateDTO;
import neo.setup.learn_center.dto.auth.teacher.TeacherDetailDTO;
import neo.setup.learn_center.dto.auth.teacher.TeacherGetDTO;
import neo.setup.learn_center.dto.auth.teacher.TeacherUpdateDTO;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.auth.teacher.TeacherServiceImpl;
import neo.setup.learn_center.utils.BaseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/teacher/*")
public class TeacherControllerImpl extends AbstractController<TeacherServiceImpl> implements TeacherController {
    public TeacherControllerImpl(TeacherServiceImpl service) {
        super(service);
    }

    @Override
    public ResponseEntity<Data<String>> create(TeacherCreateDTO DTO) {
        service.create(DTO);
        return new ResponseEntity<>(new Data<>("Successfully created - Teacher"), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Data<String>> update(TeacherUpdateDTO DTO) {
        service.update(DTO);
        return new ResponseEntity<>(new Data<>("Successfully updated - Teacher"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<String>> delete(UUID code) {
        service.delete(code);
        return new ResponseEntity<>(new Data<>("Successfully deleted - Teacher"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<TeacherGetDTO>> get(UUID code) {
        return service.get(code);
    }

    @Override
    public ResponseEntity<Data<TeacherDetailDTO>> detail(UUID code) {
        return service.detail(code);
    }

    @Override
    public ResponseEntity<Data<List<TeacherGetDTO>>> list(TeacherCriteria criteria) {
        return service.list(criteria);
    }
}
