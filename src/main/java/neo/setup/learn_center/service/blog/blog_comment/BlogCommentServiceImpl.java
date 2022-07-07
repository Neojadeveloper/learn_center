package neo.setup.learn_center.service.blog.blog_comment;

import neo.setup.learn_center.criteria.blog.blog_comment.BlogCommentCriteria;
import neo.setup.learn_center.dto.blog.blog_comment.BlogCommentCreateDTO;
import neo.setup.learn_center.dto.blog.blog_comment.BlogCommentDetailDTO;
import neo.setup.learn_center.dto.blog.blog_comment.BlogCommentGetDTO;
import neo.setup.learn_center.dto.blog.blog_comment.BlogCommentUpdateDTO;
import neo.setup.learn_center.entity.blog.blog_comment.BlogComment;
import neo.setup.learn_center.mapper.blog.blog_comment.BlogCommentMapper;
import neo.setup.learn_center.repository.blog.blog_comment.BlogCommentRepository;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.AbstractService;
import neo.setup.learn_center.validator.blog.blog_comment.BlogCommentValidator;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class BlogCommentServiceImpl extends AbstractService<BlogCommentValidator, BlogCommentMapper, BlogCommentRepository> implements BlogCommentService {
    public BlogCommentServiceImpl(BlogCommentValidator validator, BlogCommentMapper mapper, BlogCommentRepository repository) {
        super(validator, mapper, repository);
    }

    @Override
    public ResponseEntity<Data<Void>> create(BlogCommentCreateDTO DTO) {
        validator.validOnCreate(DTO);
        repository.save(mapper.toCreateDTO(DTO));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Void>> update(BlogCommentUpdateDTO DTO) {
        validator.validOnUpdate(DTO);
        BlogComment comment = repository.getByCode(DTO.getCode());
        comment.setMessage(DTO.getMessage());
        comment.setUpdatedAt(LocalDateTime.now());
        repository.save(comment);
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Void>> delete(UUID key) {
        validator.validateKey(key);
        repository.deleteByCode(key);
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<BlogCommentGetDTO>> get(UUID key) {
        validator.validateKey(key);
        return new ResponseEntity<>(new Data<>(mapper.fromGetDTO(repository.getByCode(key))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<BlogCommentDetailDTO>> detail(UUID key) {
        validator.validateKey(key);
        return new ResponseEntity<>(new Data<>(mapper.fromDetailDTO(repository.getByCode(key))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<BlogCommentGetDTO>>> list(BlogCommentCriteria criteria) {
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize());
        return new ResponseEntity<>(new Data<>(mapper.fromGetListDTO(repository.findAll(request).stream().toList()), repository.count()), HttpStatus.OK);
    }
}
