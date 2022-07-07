package neo.setup.learn_center.service.system.transaction_status;

import neo.setup.learn_center.criteria.system.transaction_status.TransactionStatusCriteria;
import neo.setup.learn_center.dto.system.transaction_status.TransactionStatusCreateDTO;
import neo.setup.learn_center.dto.system.transaction_status.TransactionStatusDetailDTO;
import neo.setup.learn_center.dto.system.transaction_status.TransactionStatusGetDTO;
import neo.setup.learn_center.dto.system.transaction_status.TransactionStatusUpdateDTO;
import neo.setup.learn_center.entity.system.transaction_status.TransactionStatus;
import neo.setup.learn_center.exception.exception.NotFoundException;
import neo.setup.learn_center.mapper.system.transaction_status.TransactionStatusMapper;
import neo.setup.learn_center.repository.system.transaction_status.TransactionStatusRepository;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.AbstractService;
import neo.setup.learn_center.validator.system.transaction_status.TransactionStatusValidator;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionStatusServiceImpl extends AbstractService<TransactionStatusValidator, TransactionStatusMapper, TransactionStatusRepository> implements TransactionStatusService {
    public TransactionStatusServiceImpl(TransactionStatusValidator validator, TransactionStatusMapper mapper, TransactionStatusRepository repository) {
        super(validator, mapper, repository);
    }

    @Override
    public ResponseEntity<Data<Void>> create(TransactionStatusCreateDTO DTO) {
        validator.validOnCreate(DTO);
        repository.save(mapper.toCreateDTO(DTO));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Void>> update(TransactionStatusUpdateDTO DTO) {
        validator.validOnUpdate(DTO);
        Optional<TransactionStatus> optional = repository.getByCode(DTO.getCode());
        if (optional.isEmpty()) {
            throw new NotFoundException("Transaction Status not found");
        }
        TransactionStatus status = optional.get();
        status.setName(DTO.getName());
        status.setPublished(DTO.isPublished());
        status.setUpdatedAt(LocalDateTime.now());
        repository.save(status);
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Void>> delete(UUID key) {
        validator.validateKey(key);
        Optional<TransactionStatus> optional = repository.getByCode(key);
        if (optional.isEmpty()) {
            throw new NotFoundException("Transaction Status not found");
        }
        repository.deleteByCode(key);
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<TransactionStatusGetDTO>> get(UUID key) {
        validator.validateKey(key);
        return new ResponseEntity<>(new Data<>(mapper.fromGetDTO(repository.getByCode(key).orElseThrow(() -> new NotFoundException("Transaction Status not found")))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<TransactionStatusDetailDTO>> detail(UUID key) {
        validator.validateKey(key);
        return new ResponseEntity<>(new Data<>(mapper.fromDetailDTO(repository.getByCode(key).orElseThrow(() -> new NotFoundException("Transaction Status not found")))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<TransactionStatusGetDTO>>> list(TransactionStatusCriteria criteria) {
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize(), criteria.getSort(), criteria.getFieldsEnum().getValue());
        return new ResponseEntity<>(new Data<>(mapper.fromGetListDTO(repository.findAll(request).stream().toList()), repository.count()), HttpStatus.OK);
    }
}
