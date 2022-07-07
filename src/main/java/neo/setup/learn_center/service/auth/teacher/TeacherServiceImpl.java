package neo.setup.learn_center.service.auth.teacher;

import neo.setup.learn_center.criteria.auth.teacher.TeacherCriteria;
import neo.setup.learn_center.dto.auth.teacher.TeacherCreateDTO;
import neo.setup.learn_center.dto.auth.teacher.TeacherDetailDTO;
import neo.setup.learn_center.dto.auth.teacher.TeacherGetDTO;
import neo.setup.learn_center.dto.auth.teacher.TeacherUpdateDTO;
import neo.setup.learn_center.entity.auth.teacher.Teacher;
import neo.setup.learn_center.exception.exception.NotFoundException;
import neo.setup.learn_center.mapper.auth.teacher.TeacherMapper;
import neo.setup.learn_center.repository.auth.teacher.TeacherRepository;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.AbstractService;
import neo.setup.learn_center.validator.auth.teacher.TeacherValidator;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TeacherServiceImpl extends AbstractService<TeacherValidator, TeacherMapper, TeacherRepository> implements TeacherService {
    public TeacherServiceImpl(TeacherValidator validator, TeacherMapper mapper, TeacherRepository repository) {
        super(validator, mapper, repository);
    }

    @Override
    public ResponseEntity<Data<Void>> create(TeacherCreateDTO DTO) {
        validator.validOnCreate(DTO);
        repository.save(mapper.toCreateDTO(DTO));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Void>> update(TeacherUpdateDTO DTO) {
        validator.validOnUpdate(DTO);
        Optional<Teacher> optional = repository.getByCode(DTO.getCode());
        if (optional.isEmpty()) {
            throw new NotFoundException("Teacher not found");
        }
        Teacher teacher = optional.get();
        teacher.setAbout(DTO.getAbout());
        teacher.setUpdatedAt(LocalDateTime.now());
        teacher.setAge(DTO.getAge());
        teacher.setExperience(DTO.getExperience());
        repository.save(teacher);
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Void>> delete(UUID key) {
        validator.validateKey(key);
        Optional<Teacher> optional = repository.getByCode(key);
        if (optional.isEmpty()) {
            throw new NotFoundException("Teacher not found");
        }
        repository.deleteByCode(key);
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<TeacherGetDTO>> get(UUID key) {
        validator.validateKey(key);
        return new ResponseEntity<>(new Data<>(mapper.fromGetDTO(repository.getByCode(key).orElseThrow(() -> new NotFoundException("Teacher not found")))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<TeacherDetailDTO>> detail(UUID key) {
        validator.validateKey(key);
        return new ResponseEntity<>(new Data<>(mapper.fromDetailDTO(repository.getByCode(key).orElseThrow(() -> new NotFoundException("Teacher not found")))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<TeacherGetDTO>>> list(TeacherCriteria criteria) {
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize());
        return new ResponseEntity<>(new Data<>(mapper.fromGetListDTO(repository.findAll(request).stream().toList()), repository.count()), HttpStatus.OK);
    }
}
