package neo.setup.learn_center.service.blog.blog;

import neo.setup.learn_center.criteria.blog.blog.BlogCriteria;
import neo.setup.learn_center.dto.blog.blog.BlogCreateDTO;
import neo.setup.learn_center.dto.blog.blog.BlogDetailDTO;
import neo.setup.learn_center.dto.blog.blog.BlogGetDTO;
import neo.setup.learn_center.dto.blog.blog.BlogUpdateDTO;
import neo.setup.learn_center.entity.blog.blog.Blog;
import neo.setup.learn_center.exception.exception.NotFoundException;
import neo.setup.learn_center.mapper.blog.blog.BlogMapper;
import neo.setup.learn_center.repository.blog.blog.BlogRepository;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.AbstractService;
import neo.setup.learn_center.validator.blog.blog.BlogValidator;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BlogServiceImpl extends AbstractService<BlogValidator, BlogMapper, BlogRepository> implements BlogService {
    public BlogServiceImpl(BlogValidator validator, BlogMapper mapper, BlogRepository repository) {
        super(validator, mapper, repository);
    }

    @Override
    public ResponseEntity<Data<Void>> create(BlogCreateDTO DTO) {
        validator.validOnCreate(DTO);
        repository.save(mapper.toCreateDTO(DTO));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Void>> update(BlogUpdateDTO DTO) {
        validator.validOnUpdate(DTO);
        Optional<Blog> optional = repository.getByCode(DTO.getCode());
        if (optional.isEmpty()) {
            throw new NotFoundException("Blog not found");
        }
        Blog blog = optional.get();
        blog.setTitle(DTO.getTitle());
        blog.setDescription(DTO.getDescription());
        blog.setCategoryId(DTO.getCategoryId());
        blog.setContent(DTO.getContent());
        blog.setImage(DTO.getImage());
        blog.setPublished(DTO.isPublished());
        blog.setUpdatedAt(LocalDateTime.now());
        repository.save(blog);
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Void>> delete(UUID key) {
        validator.validateKey(key);
        Optional<Blog> optional = repository.getByCode(key);
        if (optional.isEmpty()) {
            throw new NotFoundException("Blog not found");
        }
        repository.deleteByCode(key);
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<BlogGetDTO>> get(UUID key) {
        validator.validateKey(key);
        return new ResponseEntity<>(new Data<>(mapper.fromGetDTO(repository.getByCode(key).orElseThrow(() -> new NotFoundException("Blog not found")))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<BlogDetailDTO>> detail(UUID key) {
        validator.validateKey(key);
        return new ResponseEntity<>(new Data<>(mapper.fromDetailDTO(repository.getByCode(key).orElseThrow(() -> new NotFoundException("Blog not found")))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<BlogGetDTO>>> list(BlogCriteria criteria) {
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize(), criteria.getSort(), criteria.getFieldsEnum().getValue());
        return new ResponseEntity<>(new Data<>(mapper.fromGetListDTO(repository.findAll(request).stream().toList()), repository.count()), HttpStatus.OK);
    }
}
