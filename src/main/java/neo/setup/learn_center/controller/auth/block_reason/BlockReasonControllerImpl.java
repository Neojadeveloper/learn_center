package neo.setup.learn_center.controller.auth.block_reason;

import neo.setup.learn_center.controller.AbstractController;
import neo.setup.learn_center.criteria.auth.block_reason.BlockReasonCriteria;
import neo.setup.learn_center.dto.auth.block_reason.BlockReasonCreateDTO;
import neo.setup.learn_center.dto.auth.block_reason.BlockReasonDetailDTO;
import neo.setup.learn_center.dto.auth.block_reason.BlockReasonGetDTO;
import neo.setup.learn_center.dto.auth.block_reason.BlockReasonUpdateDTO;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.auth.block_reason.BlockReasonServiceImpl;
import neo.setup.learn_center.utils.BaseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/blockReason/*")
public class BlockReasonControllerImpl extends AbstractController<BlockReasonServiceImpl> implements BlockReasonController {

    public BlockReasonControllerImpl(BlockReasonServiceImpl service) {
        super(service);
    }

    @Override
    public ResponseEntity<Data<String>> create(BlockReasonCreateDTO DTO) {
        service.create(DTO);
        return new ResponseEntity<>(new Data<>("Successfully created - Block Reason"), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Data<String>> update(BlockReasonUpdateDTO DTO) {
        return new ResponseEntity<>(new Data<>("Successfully updated - Block Reason"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<String>> delete(UUID code) {
        return new ResponseEntity<>(new Data<>("Successfully deleted - Block Reason"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<BlockReasonGetDTO>> get(UUID code) {
        return service.get(code);
    }

    @Override
    public ResponseEntity<Data<BlockReasonDetailDTO>> detail(UUID code) {
        return service.detail(code);
    }

    @Override
    public ResponseEntity<Data<List<BlockReasonGetDTO>>> list(BlockReasonCriteria criteria) {
        return service.list(criteria);
    }
}
