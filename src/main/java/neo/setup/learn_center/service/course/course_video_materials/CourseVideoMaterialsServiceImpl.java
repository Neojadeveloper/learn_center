package neo.setup.learn_center.service.course.course_video_materials;

import neo.setup.learn_center.criteria.course.course_video_materials.CourseVideoMaterialsCriteria;
import neo.setup.learn_center.dto.course.course_video_materials.CourseVideoMaterialsCreateDTO;
import neo.setup.learn_center.dto.course.course_video_materials.CourseVideoMaterialsDetailDTO;
import neo.setup.learn_center.dto.course.course_video_materials.CourseVideoMaterialsGetDTO;
import neo.setup.learn_center.dto.course.course_video_materials.CourseVideoMaterialsUpdateDTO;
import neo.setup.learn_center.entity.course.course_video_materials.CourseVideoMaterials;
import neo.setup.learn_center.exception.exception.NotFoundException;
import neo.setup.learn_center.mapper.course.course_video_materials.CourseVideoMaterialsMapper;
import neo.setup.learn_center.repository.course.course_video_materials.CourseVideoMaterialsRepository;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.AbstractService;
import neo.setup.learn_center.validator.course.course_video_materials.CourseVideoMaterialsValidator;
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
public class CourseVideoMaterialsServiceImpl extends AbstractService<CourseVideoMaterialsValidator, CourseVideoMaterialsMapper, CourseVideoMaterialsRepository> implements CourseVideoMaterialsService {
    public CourseVideoMaterialsServiceImpl(CourseVideoMaterialsValidator validator, CourseVideoMaterialsMapper mapper, CourseVideoMaterialsRepository repository) {
        super(validator, mapper, repository);
    }

    @Override
    public ResponseEntity<Data<Void>> create(CourseVideoMaterialsCreateDTO DTO) {
        validator.validOnCreate(DTO);
        repository.save(mapper.toCreateDTO(DTO));
        return new ResponseEntity<>(new Data<>(null), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Data<Void>> update(CourseVideoMaterialsUpdateDTO DTO) {
        validator.validOnUpdate(DTO);
        CourseVideoMaterials materials = repository.findByCode(DTO.getCode());
        if (Objects.isNull(materials)) {
            throw new NotFoundException("Course Video Materials not found");
        }
        materials.setVideoId(DTO.getVideoId());
        materials.setFile(DTO.getFile());
        repository.save(materials);
        return new ResponseEntity<>(new Data<>(null), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Void>> delete(UUID key) {
        validator.validateKey(key);
        CourseVideoMaterials materials = repository.findByCode(key);
        if (Objects.isNull(materials)) {
            throw new NotFoundException("Course Video Materials not found");
        }
        repository.deleteByCode(key);
        return new ResponseEntity<>(new Data<>(null), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<CourseVideoMaterialsGetDTO>> get(UUID key) {
        validator.validateKey(key);
        CourseVideoMaterials materials = repository.findByCode(key);
        if (Objects.isNull(materials)) {
            throw new NotFoundException("Course Video Materials not found");
        }
        return new ResponseEntity<>(new Data<>(mapper.fromGetDTO(materials)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<CourseVideoMaterialsDetailDTO>> detail(UUID key) {
        validator.validateKey(key);
        CourseVideoMaterials materials = repository.findByCode(key);
        if (Objects.isNull(materials)) {
            throw new NotFoundException("Course Video Materials not found");
        }
        return new ResponseEntity<>(new Data<>(mapper.fromDetailDTO(materials)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<CourseVideoMaterialsGetDTO>>> list(CourseVideoMaterialsCriteria criteria) {
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize());
        return new ResponseEntity<>(new Data<>(mapper.fromGetListDTO(repository.findAll(request).stream().toList()), repository.count()), HttpStatus.OK);
    }
}
