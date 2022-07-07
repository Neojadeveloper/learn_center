package neo.setup.learn_center.service.course.course_rating;

import neo.setup.learn_center.criteria.course.course_rating.CourseRatingCriteria;
import neo.setup.learn_center.dto.course.course_rating.CourseRatingCreateDTO;
import neo.setup.learn_center.dto.course.course_rating.CourseRatingDetailDTO;
import neo.setup.learn_center.dto.course.course_rating.CourseRatingGetDTO;
import neo.setup.learn_center.dto.course.course_rating.CourseRatingUpdateDTO;
import neo.setup.learn_center.entity.course.course_rating.CourseRating;
import neo.setup.learn_center.exception.exception.NotFoundException;
import neo.setup.learn_center.mapper.course.course_rating.CourseRatingMapper;
import neo.setup.learn_center.repository.course.course_rating.CourseRatingRepository;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.AbstractService;
import neo.setup.learn_center.validator.course.course_rating.CourseRatingValidator;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@Transactional
public class CourseRatingServiceImpl extends AbstractService<CourseRatingValidator, CourseRatingMapper, CourseRatingRepository> implements CourseRatingService {
    public CourseRatingServiceImpl(CourseRatingValidator validator, CourseRatingMapper mapper, CourseRatingRepository repository) {
        super(validator, mapper, repository);
    }

    @Override
    public ResponseEntity<Data<Void>> create(CourseRatingCreateDTO DTO) {
        validator.validOnCreate(DTO);
        repository.save(mapper.toCreateDTO(DTO));
        return new ResponseEntity<>(new Data<>(null), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Data<Void>> update(CourseRatingUpdateDTO DTO) {
        validator.validOnUpdate(DTO);
        CourseRating rating = repository.findByCode(DTO.getCode());
        if (Objects.isNull(rating)) {
            throw new NotFoundException("Course rating not found");
        }
        rating.setViews(DTO.getViews());
        rating.setStars(DTO.getStars());
        rating.setBuyers(DTO.getBuyers());
        repository.save(rating);
        return new ResponseEntity<>(new Data<>(null), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Void>> delete(UUID key) {
        validator.validateKey(key);
        CourseRating rating = repository.findByCode(key);
        if (Objects.isNull(rating)) {
            throw new NotFoundException("Course rating not found");
        }
        repository.deleteByCode(key);
        return new ResponseEntity<>(new Data<>(null), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<CourseRatingGetDTO>> get(UUID key) {
        validator.validateKey(key);
        CourseRating rating = repository.findByCode(key);
        if (Objects.isNull(rating)) {
            throw new NotFoundException("Course rating not found");
        }
        return new ResponseEntity<>(new Data<>(mapper.fromGetDTO(rating)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<CourseRatingDetailDTO>> detail(UUID key) {
        validator.validateKey(key);
        CourseRating rating = repository.findByCode(key);
        if (Objects.isNull(rating)) {
            throw new NotFoundException("Course rating not found");
        }
        return new ResponseEntity<>(new Data<>(mapper.fromDetailDTO(rating)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<CourseRatingGetDTO>>> list(CourseRatingCriteria criteria) {
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize());
        return new ResponseEntity<>(new Data<>(mapper.fromGetListDTO(repository.findAll(request).stream().toList()), repository.count()), HttpStatus.OK);
    }
}
