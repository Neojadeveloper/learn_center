package neo.setup.learn_center.service.blog.blog_tag;

import neo.setup.learn_center.criteria.blog.blog_tag.BlogTagCriteria;
import neo.setup.learn_center.dto.blog.blog_tag.BlogTagCreateDTO;
import neo.setup.learn_center.dto.blog.blog_tag.BlogTagDetailDTO;
import neo.setup.learn_center.dto.blog.blog_tag.BlogTagGetDTO;
import neo.setup.learn_center.dto.blog.blog_tag.BlogTagUpdateDTO;
import neo.setup.learn_center.entity.blog.blog_tag.BlogTag;
import neo.setup.learn_center.exception.exception.NotFoundException;
import neo.setup.learn_center.mapper.blog.blog_tag.BlogTagMapper;
import neo.setup.learn_center.repository.blog.blog_tag.BlogTagRepository;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.AbstractService;
import neo.setup.learn_center.validator.blog.blog_tag.BlogTagValidator;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BlogTagServiceImpl extends AbstractService<BlogTagValidator, BlogTagMapper, BlogTagRepository> implements BlogTagService {
    public BlogTagServiceImpl(BlogTagValidator validator, BlogTagMapper mapper, BlogTagRepository repository) {
        super(validator, mapper, repository);
    }

    @Override
    public ResponseEntity<Data<Void>> create(BlogTagCreateDTO DTO) {
        validator.validOnCreate(DTO);
        repository.save(mapper.toCreateDTO(DTO));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Void>> update(BlogTagUpdateDTO DTO) {
        return null;
    }

    @Override
    public ResponseEntity<Data<Void>> delete(UUID key) {
        validator.validateKey(key);
        Optional<BlogTag> optional = repository.getByCode(key);
        if (optional.isEmpty()) {
            throw new NotFoundException("Blog Tag not found");
        }
        repository.deleteByCode(key);
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<BlogTagGetDTO>> get(UUID key) {
        validator.validateKey(key);
        return new ResponseEntity<>(new Data<>(mapper.fromGetDTO(repository.getByCode(key).orElseThrow(() -> new NotFoundException("Blog Tag not found")))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<BlogTagDetailDTO>> detail(UUID key) {
        validator.validateKey(key);
        return new ResponseEntity<>(new Data<>(mapper.fromDetailDTO(repository.getByCode(key).orElseThrow(() -> new NotFoundException("Blog Tag not found")))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<BlogTagGetDTO>>> list(BlogTagCriteria criteria) {
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize());
        return new ResponseEntity<>(new Data<>(mapper.fromGetListDTO(repository.findAll(request).stream().toList()), repository.count()), HttpStatus.OK);
    }
}
