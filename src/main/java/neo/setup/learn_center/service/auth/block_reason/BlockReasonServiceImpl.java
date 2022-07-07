package neo.setup.learn_center.service.auth.block_reason;

import neo.setup.learn_center.criteria.auth.block_reason.BlockReasonCriteria;
import neo.setup.learn_center.dto.auth.block_reason.BlockReasonCreateDTO;
import neo.setup.learn_center.dto.auth.block_reason.BlockReasonDetailDTO;
import neo.setup.learn_center.dto.auth.block_reason.BlockReasonGetDTO;
import neo.setup.learn_center.dto.auth.block_reason.BlockReasonUpdateDTO;
import neo.setup.learn_center.entity.auth.block_reason.AuthBlockReason;
import neo.setup.learn_center.exception.exception.NotFoundException;
import neo.setup.learn_center.mapper.auth.block_reason.BlockReasonMapper;
import neo.setup.learn_center.repository.auth.block_reason.BlockReasonRepository;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.AbstractService;
import neo.setup.learn_center.validator.auth.block_reason.BlockReasonValidator;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BlockReasonServiceImpl extends AbstractService<BlockReasonValidator, BlockReasonMapper, BlockReasonRepository> implements BlockReasonService {
    public BlockReasonServiceImpl(BlockReasonValidator validator, BlockReasonMapper mapper, BlockReasonRepository repository) {
        super(validator, mapper, repository);
    }

    @Override
    public ResponseEntity<Data<Void>> create(BlockReasonCreateDTO DTO) {
        validator.validOnCreate(DTO);
        repository.save(mapper.toCreateDTO(DTO));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Void>> update(BlockReasonUpdateDTO DTO) {
        validator.validOnUpdate(DTO);
        Optional<AuthBlockReason> optional = repository.getByCode(DTO.getCode());
        if (optional.isEmpty()) {
            throw new NotFoundException("Block Reason not found");
        }
        AuthBlockReason reason = optional.get();
        reason.setName(DTO.getName());
        reason.setPublished(DTO.isPublished());
        reason.setUpdatedAt(LocalDateTime.now());
        repository.save(reason);
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Void>> delete(UUID key) {
        validator.validateKey(key);
        Optional<AuthBlockReason> optional = repository.getByCode(key);
        if (optional.isEmpty()) {
            throw new NotFoundException("Block Reason not found");
        }
        repository.deleteByCode(key);
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<BlockReasonGetDTO>> get(UUID key) {
        validator.validateKey(key);
        return new ResponseEntity<>(new Data<>(mapper.fromGetDTO(repository.getByCode(key).orElseThrow(() -> new NotFoundException("Block Reason not found")))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<BlockReasonDetailDTO>> detail(UUID key) {
        return new ResponseEntity<>(new Data<>(mapper.fromDetailDTO(repository.getByCode(key).orElseThrow(() -> new NotFoundException("Block Reason not found")))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<BlockReasonGetDTO>>> list(BlockReasonCriteria criteria) {
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize(), criteria.getSort(), criteria.getFieldsEnum().getValue());
        return new ResponseEntity<>(new Data<>(mapper.fromGetListDTO(repository.findAll(request).stream().toList()), repository.count()), HttpStatus.OK);
    }
}
