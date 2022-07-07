package neo.setup.learn_center.service.system.tag;

import neo.setup.learn_center.criteria.system.tag.TagCriteria;
import neo.setup.learn_center.dto.system.tag.TagCreateDTO;
import neo.setup.learn_center.dto.system.tag.TagDetailDTO;
import neo.setup.learn_center.dto.system.tag.TagGetDTO;
import neo.setup.learn_center.dto.system.tag.TagUpdateDTO;
import neo.setup.learn_center.entity.system.tag.Tag;
import neo.setup.learn_center.exception.exception.NotFoundException;
import neo.setup.learn_center.mapper.system.tag.TagMapper;
import neo.setup.learn_center.repository.system.tag.TagRepository;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.AbstractService;
import neo.setup.learn_center.validator.system.tag.TagValidator;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TagServiceImpl extends AbstractService<TagValidator, TagMapper, TagRepository> implements TagService {
    public TagServiceImpl(TagValidator validator, TagMapper mapper, TagRepository repository) {
        super(validator, mapper, repository);
    }

    @Override
    public ResponseEntity<Data<Void>> create(TagCreateDTO DTO) {
        validator.validOnCreate(DTO);
        repository.save(mapper.toCreateDTO(DTO));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Void>> update(TagUpdateDTO DTO) {
        validator.validOnUpdate(DTO);
        Optional<Tag> optional = repository.getByCode(DTO.getCode());
        if (optional.isEmpty()) {
            throw new NotFoundException("Tag not found");
        }
        Tag tag = optional.get();
        tag.setName(DTO.getName());
        tag.setPublished(DTO.isPublished());
        tag.setUpdatedAt(LocalDateTime.now());
        repository.save(tag);
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Void>> delete(UUID key) {
        validator.validateKey(key);
        Optional<Tag> optional = repository.getByCode(key);
        if (optional.isEmpty()) {
            throw new NotFoundException("Tag not found");
        }
        repository.deleteByCode(key);
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<TagGetDTO>> get(UUID key) {
        validator.validateKey(key);
        return new ResponseEntity<>(new Data<>(mapper.fromGetDTO(repository.getByCode(key).orElseThrow(() -> new NotFoundException("Tag not found")))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<TagDetailDTO>> detail(UUID key) {
        validator.validateKey(key);
        return new ResponseEntity<>(new Data<>(mapper.fromDetailDTO(repository.getByCode(key).orElseThrow(() -> new NotFoundException("Tag not found")))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<TagGetDTO>>> list(TagCriteria criteria) {
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize(), criteria.getSort(), criteria.getFieldsEnum().getValue());
        return new ResponseEntity<>(new Data<>(mapper.fromGetListDTO(repository.findAll(request).stream().toList()), repository.count()), HttpStatus.OK);
    }
}
