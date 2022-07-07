package neo.setup.learn_center.service.course.course_certificate;

import neo.setup.learn_center.criteria.course.course_certificate.CourseCertificateCriteria;
import neo.setup.learn_center.dto.course.course_certificate.CourseCertificateCreateDTO;
import neo.setup.learn_center.dto.course.course_certificate.CourseCertificateDetailDTO;
import neo.setup.learn_center.dto.course.course_certificate.CourseCertificateGetDTO;
import neo.setup.learn_center.dto.course.course_certificate.CourseCertificateUpdateDTO;
import neo.setup.learn_center.entity.course.course_certificate.CourseCertificate;
import neo.setup.learn_center.exception.exception.NotFoundException;
import neo.setup.learn_center.mapper.course.course_certificate.CourseCertificateMapper;
import neo.setup.learn_center.repository.course.course_certificate.CourseCertificateRepository;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.AbstractService;
import neo.setup.learn_center.validator.course.course_certificate.CourseCertificateValidator;
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
public class CourseCertificateServiceImpl extends AbstractService<CourseCertificateValidator, CourseCertificateMapper, CourseCertificateRepository> implements CourseCertificateService {
    public CourseCertificateServiceImpl(CourseCertificateValidator validator, CourseCertificateMapper mapper, CourseCertificateRepository repository) {
        super(validator, mapper, repository);
    }

    @Override
    public ResponseEntity<Data<Void>> create(CourseCertificateCreateDTO DTO) {
        validator.validOnCreate(DTO);
        repository.save(mapper.toCreateDTO(DTO));
        return new ResponseEntity<>(new Data<>(null), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Data<Void>> update(CourseCertificateUpdateDTO DTO) {
        validator.validOnUpdate(DTO);
        CourseCertificate certificate = repository.findByCode(DTO.getCode());
        if (Objects.isNull(certificate)) {
            throw new NotFoundException("Course certificate not found");
        }
        certificate.setName(DTO.getName());
        certificate.setDescription(DTO.getDescription());
        certificate.setImage(DTO.getImage());
        certificate.setCourseId(DTO.getCourseId());
        certificate.setPublished(DTO.getIsPublished());
        repository.save(certificate);
        return new ResponseEntity<>(new Data<>(null), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Void>> delete(UUID key) {
        validator.validateKey(key);
        CourseCertificate certificate = repository.findByCode(key);
        if (Objects.isNull(certificate)) {
            throw new NotFoundException("Course certificate not found");
        }
        repository.deleteByCode(key);
        return new ResponseEntity<>(new Data<>(null), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<CourseCertificateGetDTO>> get(UUID key) {
        validator.validateKey(key);
        CourseCertificate certificate = repository.findByCode(key);
        if (Objects.isNull(certificate)) {
            throw new NotFoundException("Course certificate not found");
        }
        return new ResponseEntity<>(new Data<>(mapper.fromGetDTO(certificate)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<CourseCertificateDetailDTO>> detail(UUID key) {
        validator.validateKey(key);
        CourseCertificate certificate = repository.findByCode(key);
        if (Objects.isNull(certificate)) {
            throw new NotFoundException("Course certificate not found");
        }
        return new ResponseEntity<>(new Data<>(mapper.fromDetailDTO(certificate)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<CourseCertificateGetDTO>>> list(CourseCertificateCriteria criteria) {
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize(), criteria.getSort(), criteria.getFieldsEnum().getValue());
        return new ResponseEntity<>(new Data<>(mapper.fromGetListDTO(repository.findAll(request).stream().toList()), repository.count()), HttpStatus.OK);
    }
}
