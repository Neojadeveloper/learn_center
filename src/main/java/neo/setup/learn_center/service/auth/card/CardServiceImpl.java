package neo.setup.learn_center.service.auth.card;

import neo.setup.learn_center.criteria.auth.card.CardCriteria;
import neo.setup.learn_center.dto.auth.card.CardCreateDTO;
import neo.setup.learn_center.dto.auth.card.CardDetailDTO;
import neo.setup.learn_center.dto.auth.card.CardGetDTO;
import neo.setup.learn_center.dto.auth.card.CardUpdateDTO;
import neo.setup.learn_center.entity.auth.card.AuthCard;
import neo.setup.learn_center.exception.exception.NotFoundException;
import neo.setup.learn_center.mapper.auth.card.CardMapper;
import neo.setup.learn_center.repository.auth.card.CardRepository;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.AbstractService;
import neo.setup.learn_center.validator.auth.card.CardValidator;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CardServiceImpl extends AbstractService<CardValidator, CardMapper, CardRepository> implements CardService {
    public CardServiceImpl(CardValidator validator, CardMapper mapper, CardRepository repository) {
        super(validator, mapper, repository);
    }

    @Override
    public ResponseEntity<Data<Void>> create(CardCreateDTO DTO) {
        validator.validOnCreate(DTO);
        repository.save(mapper.toCreateDTO(DTO));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Void>> update(CardUpdateDTO DTO) {
        return null;
    }

    @Override
    public ResponseEntity<Data<Void>> delete(UUID key) {
        validator.validateKey(key);
        Optional<AuthCard> optional = repository.getByCode(key);
        if (optional.isEmpty()) {
            throw new NotFoundException("Auth Card not found");
        }
        repository.deleteByCode(key);
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<CardGetDTO>> get(UUID key) {
        validator.validateKey(key);
        return new ResponseEntity<>(new Data<>(mapper.fromGetDTO(repository.getByCode(key).orElseThrow(() -> new NotFoundException("Block Reason not found")))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<CardDetailDTO>> detail(UUID key) {
        validator.validateKey(key);
        return new ResponseEntity<>(new Data<>(mapper.fromDetailDTO(repository.getByCode(key).orElseThrow(() -> new NotFoundException("Block Reason not found")))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<CardGetDTO>>> list(CardCriteria criteria) {
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize(), criteria.getSort(), criteria.getFieldsEnum().getValue());
        return new ResponseEntity<>(new Data<>(mapper.fromGetListDTO(repository.findAll(request).stream().toList()), repository.count()), HttpStatus.OK);
    }
}
