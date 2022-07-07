package neo.setup.learn_center.service.course.course_like;

import neo.setup.learn_center.criteria.course.course_like.CourseLikeCriteria;
import neo.setup.learn_center.dto.course.course_like.CourseLikeCreateDTO;
import neo.setup.learn_center.dto.course.course_like.CourseLikeDetailDTO;
import neo.setup.learn_center.dto.course.course_like.CourseLikeGetDTO;
import neo.setup.learn_center.dto.course.course_like.CourseLikeUpdateDTO;
import neo.setup.learn_center.entity.course.course_like.CourseLike;
import neo.setup.learn_center.exception.exception.NotFoundException;
import neo.setup.learn_center.mapper.course.course_like.CourseLikeMapper;
import neo.setup.learn_center.repository.course.course_like.CourseLikeRepository;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.AbstractService;
import neo.setup.learn_center.validator.course.course_like.CourseLikeValidator;
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
public class CourseLikeServiceImpl extends AbstractService<CourseLikeValidator, CourseLikeMapper, CourseLikeRepository> implements CourseLikeService {
    public CourseLikeServiceImpl(CourseLikeValidator validator, CourseLikeMapper mapper, CourseLikeRepository repository) {
        super(validator, mapper, repository);
    }

    @Override
    public ResponseEntity<Data<Void>> create(CourseLikeCreateDTO DTO) {
        validator.validOnCreate(DTO);
        repository.save(mapper.toCreateDTO(DTO));
        return new ResponseEntity<>(new Data<>(null), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Data<Void>> update(CourseLikeUpdateDTO DTO) {
        validator.validOnUpdate(DTO);
        CourseLike like = repository.findByCode(DTO.getCode());
        if (Objects.isNull(like)) {
            throw new NotFoundException("Course like not found");
        }
        like.setCourseId(DTO.getCourseId());
        like.setUserId(DTO.getUserId());
        repository.save(like);
        return new ResponseEntity<>(new Data<>(null), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Void>> delete(UUID key) {
        validator.validateKey(key);
        CourseLike like = repository.findByCode(key);
        if (Objects.isNull(like)) {
            throw new NotFoundException("Course like not found");
        }
        repository.deleteByCode(key);
        return new ResponseEntity<>(new Data<>(null), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<CourseLikeGetDTO>> get(UUID key) {
        validator.validateKey(key);
        CourseLike like = repository.findByCode(key);
        if (Objects.isNull(like)) {
            throw new NotFoundException("Course like not found");
        }
        return new ResponseEntity<>(new Data<>(mapper.fromGetDTO(like)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<CourseLikeDetailDTO>> detail(UUID key) {
        validator.validateKey(key);
        CourseLike like = repository.findByCode(key);
        if (Objects.isNull(like)) {
            throw new NotFoundException("Course like not found");
        }
        return new ResponseEntity<>(new Data<>(mapper.fromDetailDTO(like)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<CourseLikeGetDTO>>> list(CourseLikeCriteria criteria) {
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize());
        return new ResponseEntity<>(new Data<>(mapper.fromGetListDTO(repository.findAll(request).stream().toList()), repository.count()), HttpStatus.OK);
    }
}
