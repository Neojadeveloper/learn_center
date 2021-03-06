package neo.setup.learn_center.service.blog.blog_rating;

import neo.setup.learn_center.criteria.blog.blog_rating.BlogRatingCriteria;
import neo.setup.learn_center.dto.blog.blog_rating.BlogRatingCreateDTO;
import neo.setup.learn_center.dto.blog.blog_rating.BlogRatingDetailDTO;
import neo.setup.learn_center.dto.blog.blog_rating.BlogRatingGetDTO;
import neo.setup.learn_center.dto.blog.blog_rating.BlogRatingUpdateDTO;
import neo.setup.learn_center.entity.blog.blog_rating.BlogRating;
import neo.setup.learn_center.exception.exception.NotFoundException;
import neo.setup.learn_center.mapper.blog.blog_rating.BlogRatingMapper;
import neo.setup.learn_center.repository.blog.blog_rating.BlogRatingRepository;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.AbstractService;
import neo.setup.learn_center.validator.blog.blog_rating.BlogRatingValidator;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BlogRatingServiceImpl extends AbstractService<BlogRatingValidator, BlogRatingMapper, BlogRatingRepository> implements BlogRatingService {
    public BlogRatingServiceImpl(BlogRatingValidator validator, BlogRatingMapper mapper, BlogRatingRepository repository) {
        super(validator, mapper, repository);
    }

    @Override
    public ResponseEntity<Data<Void>> create(BlogRatingCreateDTO DTO) {
        validator.validOnCreate(DTO);
        repository.save(mapper.toCreateDTO(DTO));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Void>> update(BlogRatingUpdateDTO DTO) {
        validator.validOnUpdate(DTO);
        Optional<BlogRating> optional = repository.getByCode(DTO.getCode());
        if (optional.isEmpty()) {
            throw new NotFoundException("Blog Rating not found");
        }
        BlogRating rating = optional.get();
        rating.setStars(DTO.getStars());
        rating.setViews(DTO.getViews());
        rating.setUpdatedAt(LocalDateTime.now());
        repository.save(rating);
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Void>> delete(UUID key) {
        validator.validateKey(key);
        Optional<BlogRating> optional = repository.getByCode(key);
        if (optional.isEmpty()) {
            throw new NotFoundException("Blog Rating not found");
        }
        repository.deleteByCode(key);
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<BlogRatingGetDTO>> get(UUID key) {
        validator.validateKey(key);
        return new ResponseEntity<>(new Data<>(mapper.fromGetDTO(repository.getByCode(key).orElseThrow(() -> new NotFoundException("Blog Rating not found")))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<BlogRatingDetailDTO>> detail(UUID key) {
        validator.validateKey(key);
        return new ResponseEntity<>(new Data<>(mapper.fromDetailDTO(repository.getByCode(key).orElseThrow(() -> new NotFoundException("Blog Rating not found")))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<BlogRatingGetDTO>>> list(BlogRatingCriteria criteria) {
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize());
        return new ResponseEntity<>(new Data<>(mapper.fromGetListDTO(repository.findAll(request).stream().toList()), repository.count()), HttpStatus.OK);
    }
}
