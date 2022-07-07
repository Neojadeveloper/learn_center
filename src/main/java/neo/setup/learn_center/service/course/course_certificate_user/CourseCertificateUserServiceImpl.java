package neo.setup.learn_center.service.course.course_certificate_user;

import neo.setup.learn_center.criteria.course.course_certificate_user.CourseCertificateUserCriteria;
import neo.setup.learn_center.dto.course.course_certificate_user.CourseCertificateUserCreateDTO;
import neo.setup.learn_center.dto.course.course_certificate_user.CourseCertificateUserDetailDTO;
import neo.setup.learn_center.dto.course.course_certificate_user.CourseCertificateUserGetDTO;
import neo.setup.learn_center.dto.course.course_certificate_user.CourseCertificateUserUpdateDTO;
import neo.setup.learn_center.entity.course.course_certificate_user.CourseCertificateUser;
import neo.setup.learn_center.exception.exception.NotFoundException;
import neo.setup.learn_center.mapper.course.course_certificate_user.CourseCertificateUserMapper;
import neo.setup.learn_center.repository.course.course_certificate_user.CourseCertificateUserRepository;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.AbstractService;
import neo.setup.learn_center.validator.course.course_certificate_user.CourseCertificateUserValidator;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@Transactional
public class CourseCertificateUserServiceImpl extends AbstractService<CourseCertificateUserValidator, CourseCertificateUserMapper, CourseCertificateUserRepository> implements CourseCertificateUserService {
    public CourseCertificateUserServiceImpl(CourseCertificateUserValidator validator, CourseCertificateUserMapper mapper, CourseCertificateUserRepository repository) {
        super(validator, mapper, repository);
    }

    @Override
    public ResponseEntity<Data<Void>> create(CourseCertificateUserCreateDTO DTO) {
        validator.validOnCreate(DTO);
        repository.save(mapper.toCreateDTO(DTO));
        return new ResponseEntity<>(new Data<>(null), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Data<Void>> update(CourseCertificateUserUpdateDTO DTO) {
        validator.validOnUpdate(DTO);
        CourseCertificateUser user = repository.findByCode(DTO.getCode());
        if (Objects.isNull(user)) {
            throw new NotFoundException("Course certificate user not found");
        }
        user.setUserId(DTO.getUserId());
        user.setCertificateId(DTO.getCertificateId());
        repository.save(user);
        return new ResponseEntity<>(new Data<>(null), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Void>> delete(UUID key) {
        validator.validateKey(key);
        CourseCertificateUser user = repository.findByCode(key);
        if (Objects.isNull(user)) {
            throw new NotFoundException("Course certificate user not found");
        }
        repository.deleteByCode(key);
        return new ResponseEntity<>(new Data<>(null), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<CourseCertificateUserGetDTO>> get(UUID key) {
        validator.validateKey(key);
        CourseCertificateUser user = repository.findByCode(key);
        if (Objects.isNull(user)) {
            throw new NotFoundException("Course certificate user not found");
        }
        return new ResponseEntity<>(new Data<>(mapper.fromGetDTO(user)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<CourseCertificateUserDetailDTO>> detail(UUID key) {
        validator.validateKey(key);
        CourseCertificateUser user = repository.findByCode(key);
        if (Objects.isNull(user)) {
            throw new NotFoundException("Course certificate user not found");
        }
        return new ResponseEntity<>(new Data<>(mapper.fromDetailDTO(user)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<CourseCertificateUserGetDTO>>> list(CourseCertificateUserCriteria criteria) {
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize());
        return new ResponseEntity<>(new Data<>(mapper.fromGetListDTO(repository.findAll(request).stream().toList()), repository.count()), HttpStatus.OK);
    }
}
