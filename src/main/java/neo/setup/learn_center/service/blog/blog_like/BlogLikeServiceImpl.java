package neo.setup.learn_center.service.blog.blog_like;

import neo.setup.learn_center.criteria.blog.blog_like.BlogLikeCriteria;
import neo.setup.learn_center.dto.blog.blog_like.BlogLikeCreateDTO;
import neo.setup.learn_center.dto.blog.blog_like.BlogLikeDetailDTO;
import neo.setup.learn_center.dto.blog.blog_like.BlogLikeGetDTO;
import neo.setup.learn_center.dto.blog.blog_like.BlogLikeUpdateDTO;
import neo.setup.learn_center.entity.blog.blog_like.BlogLike;
import neo.setup.learn_center.exception.exception.NotFoundException;
import neo.setup.learn_center.mapper.blog.blog_like.BlogLikeMapper;
import neo.setup.learn_center.repository.blog.blog_like.BlogLikeRepository;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.AbstractService;
import neo.setup.learn_center.validator.blog.blog_like.BlogLikeValidator;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BlogLikeServiceImpl extends AbstractService<BlogLikeValidator, BlogLikeMapper, BlogLikeRepository> implements BlogLikeService {
    public BlogLikeServiceImpl(BlogLikeValidator validator, BlogLikeMapper mapper, BlogLikeRepository repository) {
        super(validator, mapper, repository);
    }

    @Override
    public ResponseEntity<Data<Void>> create(BlogLikeCreateDTO DTO) {
        validator.validOnCreate(DTO);
        repository.save(mapper.toCreateDTO(DTO));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Void>> update(BlogLikeUpdateDTO DTO) {
        return null;
    }

    @Override
    public ResponseEntity<Data<Void>> delete(UUID key) {
        validator.validateKey(key);
        Optional<BlogLike> optional = repository.getByCode(key);
        if (optional.isEmpty()) {
            throw new NotFoundException("Blog Like not found");
        }
        repository.deleteByCode(key);
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<BlogLikeGetDTO>> get(UUID key) {
        validator.validateKey(key);
        return new ResponseEntity<>(new Data<>(mapper.fromGetDTO(repository.getByCode(key).orElseThrow(() -> new NotFoundException("Blog Like not found")))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<BlogLikeDetailDTO>> detail(UUID key) {
        validator.validateKey(key);
        return new ResponseEntity<>(new Data<>(mapper.fromDetailDTO(repository.getByCode(key).orElseThrow(() -> new NotFoundException("Blog Like not found")))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<BlogLikeGetDTO>>> list(BlogLikeCriteria criteria) {
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize());
        return new ResponseEntity<>(new Data<>(mapper.fromGetListDTO(repository.findAll(request).stream().toList()), repository.count()), HttpStatus.OK);
    }
}
