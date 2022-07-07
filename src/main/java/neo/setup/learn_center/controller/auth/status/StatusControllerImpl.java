package neo.setup.learn_center.controller.auth.status;

import neo.setup.learn_center.controller.AbstractController;
import neo.setup.learn_center.criteria.auth.status.StatusCriteria;
import neo.setup.learn_center.dto.auth.status.StatusCreateDTO;
import neo.setup.learn_center.dto.auth.status.StatusDetailDTO;
import neo.setup.learn_center.dto.auth.status.StatusGetDTO;
import neo.setup.learn_center.dto.auth.status.StatusUpdateDTO;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.auth.status.StatusServiceImpl;
import neo.setup.learn_center.utils.BaseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/status/*")
public class StatusControllerImpl extends AbstractController<StatusServiceImpl> implements StatusController {
    public StatusControllerImpl(StatusServiceImpl service) {
        super(service);
    }

    @Override
    public ResponseEntity<Data<String>> create(StatusCreateDTO DTO) {
        service.create(DTO);
        return new ResponseEntity<>(new Data<>("Successfully created - Status"), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Data<String>> update(StatusUpdateDTO DTO) {
        service.update(DTO);
        return new ResponseEntity<>(new Data<>("Successfully updated - Status"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<String>> delete(UUID code) {
        return new ResponseEntity<>(new Data<>("Successfully deleted - Status"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<StatusGetDTO>> get(UUID code) {
        return service.get(code);
    }

    @Override
    public ResponseEntity<Data<StatusDetailDTO>> detail(UUID code) {
        return service.detail(code);
    }

    @Override
    public ResponseEntity<Data<List<StatusGetDTO>>> list(StatusCriteria criteria) {
        return service.list(criteria);
    }
}
