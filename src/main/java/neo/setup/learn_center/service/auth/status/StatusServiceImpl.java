package neo.setup.learn_center.service.auth.status;

import neo.setup.learn_center.criteria.auth.status.StatusCriteria;
import neo.setup.learn_center.dto.auth.status.StatusCreateDTO;
import neo.setup.learn_center.dto.auth.status.StatusDetailDTO;
import neo.setup.learn_center.dto.auth.status.StatusGetDTO;
import neo.setup.learn_center.dto.auth.status.StatusUpdateDTO;
import neo.setup.learn_center.entity.auth.status.Status;
import neo.setup.learn_center.exception.exception.NotFoundException;
import neo.setup.learn_center.mapper.auth.status.StatusMapper;
import neo.setup.learn_center.repository.auth.status.StatusRepository;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.AbstractService;
import neo.setup.learn_center.validator.auth.status.StatusValidator;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StatusServiceImpl extends AbstractService<StatusValidator, StatusMapper, StatusRepository> implements StatusService {
    public StatusServiceImpl(StatusValidator validator, StatusMapper mapper, StatusRepository repository) {
        super(validator, mapper, repository);
    }

    @Override
    public ResponseEntity<Data<Void>> create(StatusCreateDTO DTO) {
        validator.validOnCreate(DTO);
        repository.save(mapper.toCreateDTO(DTO));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Void>> update(StatusUpdateDTO DTO) {
        validator.validOnUpdate(DTO);
        Optional<Status> optional = repository.getByCode(DTO.getCode());
        if (optional.isEmpty()) {
            throw new NotFoundException("Status not found");
        }
        Status status = optional.get();
        status.setName(DTO.getName());
        status.setPublished(DTO.getIsPublished());
        status.setUpdatedAt(LocalDateTime.now());
        repository.save(status);
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Void>> delete(UUID key) {
        validator.validateKey(key);
        Optional<Status> optional = repository.getByCode(key);
        if (optional.isEmpty()) {
            throw new NotFoundException("Status not found");
        }
        repository.deleteByCode(key);
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<StatusGetDTO>> get(UUID key) {
        validator.validateKey(key);
        return new ResponseEntity<>(new Data<>(mapper.fromGetDTO(repository.getByCode(key).orElseThrow(() -> new NotFoundException("Status not found")))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<StatusDetailDTO>> detail(UUID key) {
        validator.validateKey(key);
        return new ResponseEntity<>(new Data<>(mapper.fromDetailDTO(repository.getByCode(key).orElseThrow(() -> new NotFoundException("Status not found")))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<StatusGetDTO>>> list(StatusCriteria criteria) {
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize(), criteria.getSort(), criteria.getFieldsEnum().getValue());
        return new ResponseEntity<>(new Data<>(mapper.fromGetListDTO(repository.findAll(request).stream().toList()), repository.count()), HttpStatus.OK);
    }
}
