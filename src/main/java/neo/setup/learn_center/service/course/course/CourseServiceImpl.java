package neo.setup.learn_center.service.course.course;

import neo.setup.learn_center.criteria.course.course.CourseCriteria;
import neo.setup.learn_center.dto.course.course.CourseCreateDTO;
import neo.setup.learn_center.dto.course.course.CourseDetailDTO;
import neo.setup.learn_center.dto.course.course.CourseGetDTO;
import neo.setup.learn_center.dto.course.course.CourseUpdateDTO;
import neo.setup.learn_center.entity.course.course.Course;
import neo.setup.learn_center.exception.exception.NotFoundException;
import neo.setup.learn_center.mapper.course.course.CourseMapper;
import neo.setup.learn_center.repository.course.course.CourseRepository;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.AbstractService;
import neo.setup.learn_center.validator.course.course.CourseValidator;
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
public class CourseServiceImpl extends AbstractService<CourseValidator, CourseMapper, CourseRepository> implements CourseService {
    public CourseServiceImpl(CourseValidator validator, CourseMapper mapper, CourseRepository repository) {
        super(validator, mapper, repository);
    }

    @Override
    public ResponseEntity<Data<Void>> create(CourseCreateDTO DTO) {
        validator.validOnCreate(DTO);
        repository.save(mapper.toCreateDTO(DTO));
        return new ResponseEntity<>(new Data<>(null), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Data<Void>> update(CourseUpdateDTO DTO) {
        validator.validOnUpdate(DTO);
        Course course = repository.findByCode(DTO.getCode());
        if (Objects.isNull(course)) {
            throw new NotFoundException("Course not found");
        }
        course.setTitle(DTO.getTitle());
        course.setDescription(DTO.getDescription());
        course.setImage(DTO.getImage());
        course.setContent(DTO.getContent());
        course.setCategoryId(DTO.getCategoryId());
        course.setPublished(DTO.getIsPublished());
        repository.save(course);
        return new ResponseEntity<>(new Data<>(null), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Void>> delete(UUID key) {
        validator.validateKey(key);
        Course course = repository.findByCode(key);
        if (Objects.isNull(course)) {
            throw new NotFoundException("Course not found");
        }
        repository.deleteByCode(key);
        return new ResponseEntity<>(new Data<>(null), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<CourseGetDTO>> get(UUID key) {
        validator.validateKey(key);
        Course course = repository.findByCode(key);
        if (Objects.isNull(course)) {
            throw new NotFoundException("Course not found");
        }
        return new ResponseEntity<>(new Data<>(mapper.fromGetDTO(course)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<CourseDetailDTO>> detail(UUID key) {
        validator.validateKey(key);
        Course course = repository.findByCode(key);
        if (Objects.isNull(course)) {
            throw new NotFoundException("Course not found");
        }
        return new ResponseEntity<>(new Data<>(mapper.fromDetailDTO(course)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<CourseGetDTO>>> list(CourseCriteria criteria) {
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize(), criteria.getSort(), criteria.getFieldsEnum().getValue());
        return new ResponseEntity<>(new Data<>(mapper.fromGetListDTO(repository.findAll(request).stream().toList()), repository.count()), HttpStatus.OK);
    }
}
