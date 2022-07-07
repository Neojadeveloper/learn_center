package neo.setup.learn_center.controller.system.tag;

import neo.setup.learn_center.controller.AbstractController;
import neo.setup.learn_center.criteria.system.tag.TagCriteria;
import neo.setup.learn_center.dto.system.tag.TagCreateDTO;
import neo.setup.learn_center.dto.system.tag.TagDetailDTO;
import neo.setup.learn_center.dto.system.tag.TagGetDTO;
import neo.setup.learn_center.dto.system.tag.TagUpdateDTO;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.system.tag.TagServiceImpl;
import neo.setup.learn_center.utils.BaseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/tag/*")
public class TagControllerImpl extends AbstractController<TagServiceImpl> implements TagController {
    public TagControllerImpl(TagServiceImpl service) {
        super(service);
    }

    @Override
    public ResponseEntity<Data<String>> create(TagCreateDTO DTO) {
        service.create(DTO);
        return new ResponseEntity<>(new Data<>("Successfully created - Tag"), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Data<String>> update(TagUpdateDTO DTO) {
        service.update(DTO);
        return new ResponseEntity<>(new Data<>("Successfully updated - Tag"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<String>> delete(UUID code) {
        service.delete(code);
        return new ResponseEntity<>(new Data<>("Successfully deleted - Tag"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<TagGetDTO>> get(UUID code) {
        return service.get(code);
    }

    @Override
    public ResponseEntity<Data<TagDetailDTO>> detail(UUID code) {
        return service.detail(code);
    }

    @Override
    public ResponseEntity<Data<List<TagGetDTO>>> list(TagCriteria criteria) {
        return service.list(criteria);
    }
}
