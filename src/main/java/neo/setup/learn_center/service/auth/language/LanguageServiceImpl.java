package neo.setup.learn_center.service.auth.language;

import neo.setup.learn_center.criteria.auth.language.LanguageCriteria;
import neo.setup.learn_center.dto.auth.language.LanguageCreateDTO;
import neo.setup.learn_center.dto.auth.language.LanguageDetailDTO;
import neo.setup.learn_center.dto.auth.language.LanguageGetDTO;
import neo.setup.learn_center.dto.auth.language.LanguageUpdateDTO;
import neo.setup.learn_center.entity.auth.language.Language;
import neo.setup.learn_center.exception.exception.NotFoundException;
import neo.setup.learn_center.mapper.auth.language.LanguageMapper;
import neo.setup.learn_center.repository.auth.language.LanguageRepository;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.AbstractService;
import neo.setup.learn_center.validator.auth.language.LanguageValidator;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class LanguageServiceImpl extends AbstractService<LanguageValidator, LanguageMapper, LanguageRepository> implements LanguageService {

    public LanguageServiceImpl(LanguageValidator validator, LanguageMapper mapper, LanguageRepository repository) {
        super(validator, mapper, repository);
    }

    @Override
    public ResponseEntity<Data<Void>> create(LanguageCreateDTO DTO) {
        validator.validOnCreate(DTO);
        repository.save(mapper.toCreateDTO(DTO));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Void>> update(LanguageUpdateDTO DTO) {
        validator.validOnUpdate(DTO);
        Optional<Language> optional = repository.getByCode(DTO.getCode());
        if (optional.isEmpty()) {
            throw new NotFoundException("Language not found");
        }
        Language language = optional.get();
        language.setName(DTO.getName());
        language.setPublished(DTO.isPublished());
        language.setUpdatedAt(LocalDateTime.now());
        repository.save(language);
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Void>> delete(UUID key) {
        validator.validateKey(key);
        Optional<Language> optional = repository.getByCode(key);
        if (optional.isEmpty()) {
            throw new NotFoundException("Language not found");
        }
        repository.deleteByCode(key);
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<LanguageGetDTO>> get(UUID key) {
        validator.validateKey(key);
        return new ResponseEntity<>(new Data<>(mapper.fromGetDTO(repository.getByCode(key).orElseThrow(() -> new NotFoundException("Language not found")))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<LanguageDetailDTO>> detail(UUID key) {
        validator.validateKey(key);
        return new ResponseEntity<>(new Data<>(mapper.fromDetailDTO(repository.getByCode(key).orElseThrow(() -> new NotFoundException("Language not found")))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<LanguageGetDTO>>> list(LanguageCriteria criteria) {
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize(), criteria.getSort(), criteria.getFieldsEnum().getValue());
        return new ResponseEntity<>(new Data<>(mapper.fromGetListDTO(repository.findAll(request).stream().toList()), repository.count()), HttpStatus.OK);
    }
}
