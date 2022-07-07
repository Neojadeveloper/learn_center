package neo.setup.learn_center.service.auth.teacher_skills;

import neo.setup.learn_center.criteria.auth.teacher_skills.TeacherSkillsCriteria;
import neo.setup.learn_center.dto.auth.teacher_skills.TeacherSkillsCreateDTO;
import neo.setup.learn_center.dto.auth.teacher_skills.TeacherSkillsDetailDTO;
import neo.setup.learn_center.dto.auth.teacher_skills.TeacherSkillsGetDTO;
import neo.setup.learn_center.dto.auth.teacher_skills.TeacherSkillsUpdateDTO;
import neo.setup.learn_center.entity.auth.teacher_skills.TeacherSkills;
import neo.setup.learn_center.exception.exception.NotFoundException;
import neo.setup.learn_center.mapper.auth.teacher_skills.TeacherSkillsMapper;
import neo.setup.learn_center.repository.auth.teacher_skills.TeacherSkillsRepository;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.AbstractService;
import neo.setup.learn_center.validator.auth.teacher_skills.TeacherSkillsValidator;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TeacherSkillsServiceImpl extends AbstractService<TeacherSkillsValidator, TeacherSkillsMapper, TeacherSkillsRepository> implements TeacherSkillsService {
    public TeacherSkillsServiceImpl(TeacherSkillsValidator validator, TeacherSkillsMapper mapper, TeacherSkillsRepository repository) {
        super(validator, mapper, repository);
    }

    @Override
    public ResponseEntity<Data<Void>> create(TeacherSkillsCreateDTO DTO) {
        validator.validOnCreate(DTO);
        repository.save(mapper.toCreateDTO(DTO));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Void>> update(TeacherSkillsUpdateDTO DTO) {
        return null;
    }

    @Override
    public ResponseEntity<Data<Void>> delete(UUID key) {
        validator.validateKey(key);
        Optional<TeacherSkills> optional = repository.getByCode(key);
        if (optional.isEmpty()) {
            throw new NotFoundException("Teacher Skills not found");
        }
        repository.deleteByCode(key);
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<TeacherSkillsGetDTO>> get(UUID key) {
        validator.validateKey(key);
        return new ResponseEntity<>(new Data<>(mapper.fromGetDTO(repository.getByCode(key).orElseThrow(() -> new NotFoundException("Teacher Skills not found")))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<TeacherSkillsDetailDTO>> detail(UUID key) {
        validator.validateKey(key);
        return new ResponseEntity<>(new Data<>(mapper.fromDetailDTO(repository.getByCode(key).orElseThrow(() -> new NotFoundException("Teacher Skills not found")))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<TeacherSkillsGetDTO>>> list(TeacherSkillsCriteria criteria) {
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize());
        return new ResponseEntity<>(new Data<>(mapper.fromGetListDTO(repository.findAll(request).stream().toList()), repository.count()), HttpStatus.OK);
    }
}
