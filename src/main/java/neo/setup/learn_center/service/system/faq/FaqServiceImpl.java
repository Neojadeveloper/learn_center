package neo.setup.learn_center.service.system.faq;

import neo.setup.learn_center.criteria.system.faq.FaqCriteria;
import neo.setup.learn_center.dto.system.faq.FaqCreateDTO;
import neo.setup.learn_center.dto.system.faq.FaqDetailDTO;
import neo.setup.learn_center.dto.system.faq.FaqGetDTO;
import neo.setup.learn_center.dto.system.faq.FaqUpdateDTO;
import neo.setup.learn_center.entity.system.faq.Faq;
import neo.setup.learn_center.exception.exception.NotFoundException;
import neo.setup.learn_center.mapper.system.faq.FaqMapper;
import neo.setup.learn_center.repository.system.faq.FaqRepository;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.AbstractService;
import neo.setup.learn_center.validator.system.faq.FaqValidator;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FaqServiceImpl extends AbstractService<FaqValidator, FaqMapper, FaqRepository> implements FaqService {
    public FaqServiceImpl(FaqValidator validator, FaqMapper mapper, FaqRepository repository) {
        super(validator, mapper, repository);
    }

    @Override
    public ResponseEntity<Data<Void>> create(FaqCreateDTO DTO) {
        validator.validOnCreate(DTO);
        repository.save(mapper.toCreateDTO(DTO));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Void>> update(FaqUpdateDTO DTO) {
        return null;
    }

    @Override
    public ResponseEntity<Data<Void>> delete(UUID key) {
        validator.validateKey(key);
        Optional<Faq> optional = repository.getByCode(key);
        if (optional.isEmpty()) {
            throw new NotFoundException("Faq not found");
        }
        repository.deleteByCode(key);
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<FaqGetDTO>> get(UUID key) {
        validator.validateKey(key);
        return new ResponseEntity<>(new Data<>(mapper.fromGetDTO(repository.getByCode(key).orElseThrow(() -> new NotFoundException("Faq not found")))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<FaqDetailDTO>> detail(UUID key) {
        validator.validateKey(key);
        return new ResponseEntity<>(new Data<>(mapper.fromDetailDTO(repository.getByCode(key).orElseThrow(() -> new NotFoundException("Faq not found")))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<FaqGetDTO>>> list(FaqCriteria criteria) {
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize());
        return new ResponseEntity<>(new Data<>(mapper.fromGetListDTO(repository.findAll(request).stream().toList()), repository.count()), HttpStatus.OK);
    }
}
