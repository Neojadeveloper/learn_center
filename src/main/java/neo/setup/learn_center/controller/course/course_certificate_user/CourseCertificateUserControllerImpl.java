package neo.setup.learn_center.controller.course.course_certificate_user;

import neo.setup.learn_center.controller.AbstractController;
import neo.setup.learn_center.criteria.course.course_certificate_user.CourseCertificateUserCriteria;
import neo.setup.learn_center.dto.course.course_certificate_user.CourseCertificateUserCreateDTO;
import neo.setup.learn_center.dto.course.course_certificate_user.CourseCertificateUserDetailDTO;
import neo.setup.learn_center.dto.course.course_certificate_user.CourseCertificateUserGetDTO;
import neo.setup.learn_center.dto.course.course_certificate_user.CourseCertificateUserUpdateDTO;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.course.course_certificate_user.CourseCertificateUserServiceImpl;
import neo.setup.learn_center.utils.BaseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/course-cert  ificate-user/*")
public class CourseCertificateUserControllerImpl extends AbstractController<CourseCertificateUserServiceImpl> implements CourseCertificateUserController {
    public CourseCertificateUserControllerImpl(CourseCertificateUserServiceImpl service) {
        super(service);
    }

    @Override
    public ResponseEntity<Data<String>> create(CourseCertificateUserCreateDTO DTO) {
        service.create(DTO);
        return new ResponseEntity<>(new Data<>("Successfully created - Course Certificate User"), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Data<String>> update(CourseCertificateUserUpdateDTO DTO) {
        service.update(DTO);
        return new ResponseEntity<>(new Data<>("Successfully updated - Course Certificate User"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<String>> delete(UUID code) {
        service.delete(code);
        return new ResponseEntity<>(new Data<>("Successfully deleted - Course Certificate User"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<CourseCertificateUserGetDTO>> get(UUID code) {
        return service.get(code);
    }

    @Override
    public ResponseEntity<Data<CourseCertificateUserDetailDTO>> detail(UUID code) {
        return service.detail(code);
    }

    @Override
    public ResponseEntity<Data<List<CourseCertificateUserGetDTO>>> list(CourseCertificateUserCriteria criteria) {
        return service.list(criteria);
    }
}
