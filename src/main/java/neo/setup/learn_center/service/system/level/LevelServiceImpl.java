package neo.setup.learn_center.service.system.level;

import neo.setup.learn_center.criteria.system.level.LevelCriteria;
import neo.setup.learn_center.dto.system.level.LevelCreateDTO;
import neo.setup.learn_center.dto.system.level.LevelDetailDTO;
import neo.setup.learn_center.dto.system.level.LevelGetDTO;
import neo.setup.learn_center.dto.system.level.LevelUpdateDTO;
import neo.setup.learn_center.entity.system.level.Level;
import neo.setup.learn_center.exception.exception.NotFoundException;
import neo.setup.learn_center.mapper.system.level.LevelMapper;
import neo.setup.learn_center.repository.system.level.LevelRepository;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.AbstractService;
import neo.setup.learn_center.validator.system.level.LevelValidator;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LevelServiceImpl extends AbstractService<LevelValidator, LevelMapper, LevelRepository> implements LevelService {
    public LevelServiceImpl(LevelValidator validator, LevelMapper mapper, LevelRepository repository) {
        super(validator, mapper, repository);
    }

    @Override
    public ResponseEntity<Data<Void>> create(LevelCreateDTO DTO) {
        validator.validOnCreate(DTO);
        repository.save(mapper.toCreateDTO(DTO));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Void>> update(LevelUpdateDTO DTO) {
        validator.validOnUpdate(DTO);
        Optional<Level> optional = repository.getByCode(DTO.getCode());
        if (optional.isEmpty()) {
            throw new NotFoundException("Level not found");
        }
        Level level = optional.get();
        level.setName(DTO.getName());
        level.setPublished(DTO.isPublished());
        level.setUpdatedAt(LocalDateTime.now());
        repository.save(level);
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Void>> delete(UUID key) {
        validator.validateKey(key);
        Optional<Level> optional = repository.getByCode(key);
        if (optional.isEmpty()) {
            throw new NotFoundException("Level not found");
        }
        repository.deleteByCode(key);
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<LevelGetDTO>> get(UUID key) {
        validator.validateKey(key);
        return new ResponseEntity<>(new Data<>(mapper.fromGetDTO(repository.getByCode(key).orElseThrow(() -> new NotFoundException("Level not found")))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<LevelDetailDTO>> detail(UUID key) {
        validator.validateKey(key);
        return new ResponseEntity<>(new Data<>(mapper.fromDetailDTO(repository.getByCode(key).orElseThrow(() -> new NotFoundException("Level not found")))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<LevelGetDTO>>> list(LevelCriteria criteria) {
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize(), criteria.getSort(), criteria.getFieldsEnum().getValue());
        return new ResponseEntity<>(new Data<>(mapper.fromGetListDTO(repository.findAll(request).stream().toList()), repository.count()), HttpStatus.OK);
    }
}
