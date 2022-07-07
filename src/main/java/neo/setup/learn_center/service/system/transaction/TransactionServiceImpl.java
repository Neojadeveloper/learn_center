package neo.setup.learn_center.service.system.transaction;

import neo.setup.learn_center.criteria.system.transaction.TransactionCriteria;
import neo.setup.learn_center.dto.system.transaction.TransactionCreateDTO;
import neo.setup.learn_center.dto.system.transaction.TransactionDetailDTO;
import neo.setup.learn_center.dto.system.transaction.TransactionGetDTO;
import neo.setup.learn_center.dto.system.transaction.TransactionUpdateDTO;
import neo.setup.learn_center.entity.system.transaction.Transaction;
import neo.setup.learn_center.exception.exception.NotFoundException;
import neo.setup.learn_center.mapper.system.transaction.TransactionMapper;
import neo.setup.learn_center.repository.system.transaction.TransactionRepository;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.AbstractService;
import neo.setup.learn_center.validator.system.transaction.TransactionValidator;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionServiceImpl extends AbstractService<TransactionValidator, TransactionMapper, TransactionRepository> implements TransactionService {
    public TransactionServiceImpl(TransactionValidator validator, TransactionMapper mapper, TransactionRepository repository) {
        super(validator, mapper, repository);
    }

    @Override
    public ResponseEntity<Data<Void>> create(TransactionCreateDTO DTO) {
        validator.validOnCreate(DTO);
        repository.save(mapper.toCreateDTO(DTO));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Void>> update(TransactionUpdateDTO DTO) {
        return null;
    }

    @Override
    public ResponseEntity<Data<Void>> delete(UUID key) {
        validator.validateKey(key);
        Optional<Transaction> optional = repository.getByCode(key);
        if (optional.isEmpty()) {
            throw new NotFoundException("Transaction not found");
        }
        repository.deleteByCode(key);
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<TransactionGetDTO>> get(UUID key) {
        validator.validateKey(key);
        return new ResponseEntity<>(new Data<>(mapper.fromGetDTO(repository.getByCode(key).orElseThrow(() -> new NotFoundException("Transaction not found")))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<TransactionDetailDTO>> detail(UUID key) {
        validator.validateKey(key);
        return new ResponseEntity<>(new Data<>(mapper.fromDetailDTO(repository.getByCode(key).orElseThrow(() -> new NotFoundException("Transaction not found")))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<TransactionGetDTO>>> list(TransactionCriteria criteria) {
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize(), criteria.getSort(), criteria.getFieldsEnum().getValue());
        return new ResponseEntity<>(new Data<>(mapper.fromGetListDTO(repository.findAll(request).stream().toList()), repository.count()), HttpStatus.OK);
    }
}
