package neo.setup.learn_center.service.course.course_video;

import neo.setup.learn_center.criteria.course.course_video.CourseVideoCriteria;
import neo.setup.learn_center.dto.course.course_video.CourseVideoCreateDTO;
import neo.setup.learn_center.dto.course.course_video.CourseVideoDetailDTO;
import neo.setup.learn_center.dto.course.course_video.CourseVideoGetDTO;
import neo.setup.learn_center.dto.course.course_video.CourseVideoUpdateDTO;
import neo.setup.learn_center.entity.course.course_video.CourseVideo;
import neo.setup.learn_center.exception.exception.NotFoundException;
import neo.setup.learn_center.mapper.course.course_video.CourseVideoMapper;
import neo.setup.learn_center.repository.course.course_video.CourseVideoRepository;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.AbstractService;
import neo.setup.learn_center.validator.course.course_video.CourseVideoValidator;
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
public class CourseVideoServiceImpl extends AbstractService<CourseVideoValidator, CourseVideoMapper, CourseVideoRepository> implements CourseVideoService {
    public CourseVideoServiceImpl(CourseVideoValidator validator, CourseVideoMapper mapper, CourseVideoRepository repository) {
        super(validator, mapper, repository);
    }

    @Override
    public ResponseEntity<Data<Void>> create(CourseVideoCreateDTO DTO) {
        validator.validOnCreate(DTO);
        repository.save(mapper.toCreateDTO(DTO));
        return new ResponseEntity<>(new Data<>(null), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Data<Void>> update(CourseVideoUpdateDTO DTO) {
        validator.validOnUpdate(DTO);
        CourseVideo video = repository.findByCode(DTO.getCode());
        if (Objects.isNull(video)) {
            throw new NotFoundException("Course Video not found");
        }
        video.setCourseId(DTO.getCourseId());
        video.setVideo(DTO.getVideo());
        video.setTime(DTO.getTime());
        video.setPublished(DTO.getIsPublished());
        repository.save(video);
        return new ResponseEntity<>(new Data<>(null), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Void>> delete(UUID key) {
        validator.validateKey(key);
        CourseVideo video = repository.findByCode(key);
        if (Objects.isNull(video)) {
            throw new NotFoundException("Course Video not found");
        }
        repository.deleteByCode(key);
        return new ResponseEntity<>(new Data<>(null), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<CourseVideoGetDTO>> get(UUID key) {
        validator.validateKey(key);
        CourseVideo video = repository.findByCode(key);
        if (Objects.isNull(video)) {
            throw new NotFoundException("Course Video not found");
        }
        return new ResponseEntity<>(new Data<>(mapper.fromGetDTO(video)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<CourseVideoDetailDTO>> detail(UUID key) {
        validator.validateKey(key);
        CourseVideo video = repository.findByCode(key);
        if (Objects.isNull(video)) {
            throw new NotFoundException("Course Video not found");
        }
        return new ResponseEntity<>(new Data<>(mapper.fromDetailDTO(video)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<CourseVideoGetDTO>>> list(CourseVideoCriteria criteria) {
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize());
        return new ResponseEntity<>(new Data<>(mapper.fromGetListDTO(repository.findAll(request).stream().toList()), repository.count()), HttpStatus.OK);
    }
}
