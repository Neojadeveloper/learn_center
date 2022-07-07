package neo.setup.learn_center.service.system.skill;

import neo.setup.learn_center.criteria.system.skill.SkillCriteria;
import neo.setup.learn_center.dto.system.skill.SkillCreateDTO;
import neo.setup.learn_center.dto.system.skill.SkillDetailDTO;
import neo.setup.learn_center.dto.system.skill.SkillGetDTO;
import neo.setup.learn_center.dto.system.skill.SkillUpdateDTO;
import neo.setup.learn_center.entity.system.skill.Skill;
import neo.setup.learn_center.exception.exception.NotFoundException;
import neo.setup.learn_center.mapper.system.skill.SkillMapper;
import neo.setup.learn_center.repository.system.skill.SkillRepository;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.AbstractService;
import neo.setup.learn_center.validator.system.skill.SkillValidator;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SkillServiceImpl extends AbstractService<SkillValidator, SkillMapper, SkillRepository> implements SkillService {
    public SkillServiceImpl(SkillValidator validator, SkillMapper mapper, SkillRepository repository) {
        super(validator, mapper, repository);
    }

    @Override
    public ResponseEntity<Data<Void>> create(SkillCreateDTO DTO) {
        validator.validOnCreate(DTO);
        repository.save(mapper.toCreateDTO(DTO));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Void>> update(SkillUpdateDTO DTO) {
        validator.validOnUpdate(DTO);
        Optional<Skill> optional = repository.getByCode(DTO.getCode());
        if (optional.isEmpty()) {
            throw new NotFoundException("Skill not found");
        }
        Skill skill = optional.get();
        skill.setName(DTO.getName());
        skill.setPublished(DTO.isPublished());
        skill.setUpdatedAt(LocalDateTime.now());
        repository.save(skill);
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Void>> delete(UUID key) {
        validator.validateKey(key);
        Optional<Skill> optional = repository.getByCode(key);
        if (optional.isEmpty()) {
            throw new NotFoundException("Skill not found");
        }
        repository.deleteByCode(key);
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<SkillGetDTO>> get(UUID key) {
        validator.validateKey(key);
        return new ResponseEntity<>(new Data<>(mapper.fromGetDTO(repository.getByCode(key).orElseThrow(() -> new NotFoundException("Skill not found")))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<SkillDetailDTO>> detail(UUID key) {
        validator.validateKey(key);
        return new ResponseEntity<>(new Data<>(mapper.fromDetailDTO(repository.getByCode(key).orElseThrow(() -> new NotFoundException("Skill not found")))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<SkillGetDTO>>> list(SkillCriteria criteria) {
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize(), criteria.getSort(), criteria.getFieldsEnum().getValue());
        return new ResponseEntity<>(new Data<>(mapper.fromGetListDTO(repository.findAll(request).stream().toList()), repository.count()), HttpStatus.OK);
    }
}
