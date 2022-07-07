package neo.setup.learn_center.controller.system.level;

import neo.setup.learn_center.controller.AbstractController;
import neo.setup.learn_center.criteria.system.level.LevelCriteria;
import neo.setup.learn_center.dto.system.level.LevelCreateDTO;
import neo.setup.learn_center.dto.system.level.LevelDetailDTO;
import neo.setup.learn_center.dto.system.level.LevelGetDTO;
import neo.setup.learn_center.dto.system.level.LevelUpdateDTO;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.system.level.LevelServiceImpl;
import neo.setup.learn_center.utils.BaseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/level/*")
public class LevelControllerImpl extends AbstractController<LevelServiceImpl> implements LevelController{
    public LevelControllerImpl(LevelServiceImpl service) {
        super(service);
    }

    @Override
    public ResponseEntity<Data<String>> create(LevelCreateDTO DTO) {
        service.create(DTO);
        return new ResponseEntity<>(new Data<>("Successfully created - Level"), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Data<String>> update(LevelUpdateDTO DTO) {
        service.update(DTO);
        return new ResponseEntity<>(new Data<>("Successfully updated - Level"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<String>> delete(UUID code) {
        service.delete(code);
        return new ResponseEntity<>(new Data<>("Successfully deleted - Level"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<LevelGetDTO>> get(UUID code) {
        return service.get(code);
    }

    @Override
    public ResponseEntity<Data<LevelDetailDTO>> detail(UUID code) {
        return service.detail(code);
    }

    @Override
    public ResponseEntity<Data<List<LevelGetDTO>>> list(LevelCriteria criteria) {
        return service.list(criteria);
    }
}
