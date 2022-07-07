package neo.setup.learn_center.service.course.course_video_task;

import neo.setup.learn_center.criteria.course.course_video_task.CourseVideoTaskCriteria;
import neo.setup.learn_center.dto.course.course_video_task.CourseVideoTaskCreateDTO;
import neo.setup.learn_center.dto.course.course_video_task.CourseVideoTaskDetailDTO;
import neo.setup.learn_center.dto.course.course_video_task.CourseVideoTaskGetDTO;
import neo.setup.learn_center.dto.course.course_video_task.CourseVideoTaskUpdateDTO;
import neo.setup.learn_center.entity.course.course_video_task.CourseVideoTask;
import neo.setup.learn_center.exception.exception.NotFoundException;
import neo.setup.learn_center.mapper.course.course_video_task.CourseVideoTaskMapper;
import neo.setup.learn_center.repository.course.course_video_task.CourseVideoTaskRepository;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.AbstractService;
import neo.setup.learn_center.validator.course.course_video_task.CourseVideoTaskValidator;
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
public class CourseVideoTaskServiceImpl extends AbstractService<CourseVideoTaskValidator, CourseVideoTaskMapper, CourseVideoTaskRepository> implements CourseVideoTaskService {
    public CourseVideoTaskServiceImpl(CourseVideoTaskValidator validator, CourseVideoTaskMapper mapper, CourseVideoTaskRepository repository) {
        super(validator, mapper, repository);
    }

    @Override
    public ResponseEntity<Data<Void>> create(CourseVideoTaskCreateDTO DTO) {
        validator.validOnCreate(DTO);
        repository.save(mapper.toCreateDTO(DTO));
        return new ResponseEntity<>(new Data<>(null), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Data<Void>> update(CourseVideoTaskUpdateDTO DTO) {
        validator.validOnUpdate(DTO);
        CourseVideoTask task = repository.findByCode(DTO.getCode());
        if (Objects.isNull(task)) {
            throw new NotFoundException("Course Video Task not found");
        }
        task.setVideoId(DTO.getVideoId());
        task.setTask(DTO.getTask());
        task.setPublished(DTO.getIsPublished());
        repository.save(task);
        return new ResponseEntity<>(new Data<>(null), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Void>> delete(UUID key) {
        validator.validateKey(key);
        CourseVideoTask task = repository.findByCode(key);
        if (Objects.isNull(task)) {
            throw new NotFoundException("Course Video Task not found");
        }
        repository.deleteByCode(key);
        return new ResponseEntity<>(new Data<>(null), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<CourseVideoTaskGetDTO>> get(UUID key) {
        validator.validateKey(key);
        CourseVideoTask task = repository.findByCode(key);
        if (Objects.isNull(task)) {
            throw new NotFoundException("Course Video Task not found");
        }
        return new ResponseEntity<>(new Data<>(mapper.fromGetDTO(task)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<CourseVideoTaskDetailDTO>> detail(UUID key) {
        validator.validateKey(key);
        CourseVideoTask task = repository.findByCode(key);
        if (Objects.isNull(task)) {
            throw new NotFoundException("Course Video Task not found");
        }
        return new ResponseEntity<>(new Data<>(mapper.fromDetailDTO(task)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<CourseVideoTaskGetDTO>>> list(CourseVideoTaskCriteria criteria) {
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize());
        return new ResponseEntity<>(new Data<>(mapper.fromGetListDTO(repository.findAll(request).stream().toList()), repository.count()), HttpStatus.OK);
    }
}
