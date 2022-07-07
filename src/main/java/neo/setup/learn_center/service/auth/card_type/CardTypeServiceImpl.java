package neo.setup.learn_center.service.auth.card_type;

import neo.setup.learn_center.criteria.auth.card_type.CardTypeCriteria;
import neo.setup.learn_center.dto.auth.card_type.CardTypeCreateDTO;
import neo.setup.learn_center.dto.auth.card_type.CardTypeDetailDTO;
import neo.setup.learn_center.dto.auth.card_type.CardTypeGetDTO;
import neo.setup.learn_center.dto.auth.card_type.CardTypeUpdateDTO;
import neo.setup.learn_center.entity.auth.card_type.AuthCardType;
import neo.setup.learn_center.exception.exception.NotFoundException;
import neo.setup.learn_center.mapper.auth.card_type.CardTypeMapper;
import neo.setup.learn_center.repository.auth.card_type.CardTypeRepository;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.AbstractService;
import neo.setup.learn_center.validator.auth.card_type.CardTypeValidator;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CardTypeServiceImpl extends AbstractService<CardTypeValidator, CardTypeMapper, CardTypeRepository> implements CardTypeService {
    public CardTypeServiceImpl(CardTypeValidator validator, CardTypeMapper mapper, CardTypeRepository repository) {
        super(validator, mapper, repository);
    }

    @Override
    public ResponseEntity<Data<Void>> create(CardTypeCreateDTO DTO) {
        validator.validOnCreate(DTO);
        repository.save(mapper.toCreateDTO(DTO));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Void>> update(CardTypeUpdateDTO DTO) {
        validator.validOnUpdate(DTO);
        Optional<AuthCardType> optional = repository.getByCode(DTO.getCode());
        if (optional.isEmpty()) {
            throw new NotFoundException("Card Type not found");
        }
        AuthCardType cardType = optional.get();
        cardType.setName(DTO.getName());
        cardType.setPublished(DTO.isPublished());
        cardType.setUpdatedAt(LocalDateTime.now());
        repository.save(cardType);
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Void>> delete(UUID key) {
        validator.validateKey(key);
        Optional<AuthCardType> optional = repository.getByCode(key);
        if (optional.isEmpty()) {
            throw new NotFoundException("Card Type not found");
        }
        repository.deleteByCode(key);
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<CardTypeGetDTO>> get(UUID key) {
        validator.validateKey(key);
        return new ResponseEntity<>(new Data<>(mapper.fromGetDTO(repository.getByCode(key).orElseThrow(() -> new NotFoundException("Card Type not found")))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<CardTypeDetailDTO>> detail(UUID key) {
        validator.validateKey(key);
        return new ResponseEntity<>(new Data<>(mapper.fromDetailDTO(repository.getByCode(key).orElseThrow(() -> new NotFoundException("Card Type not found")))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<CardTypeGetDTO>>> list(CardTypeCriteria criteria) {
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize(), criteria.getSort(), criteria.getFieldsEnum().getValue());
        return new ResponseEntity<>(new Data<>(mapper.fromGetListDTO(repository.findAll(request).stream().toList()), repository.count()), HttpStatus.OK);
    }
}
