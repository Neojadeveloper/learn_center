package neo.setup.learn_center.controller.auth.card_type;

import neo.setup.learn_center.controller.AbstractController;
import neo.setup.learn_center.criteria.auth.card_type.CardTypeCriteria;
import neo.setup.learn_center.dto.auth.card_type.CardTypeCreateDTO;
import neo.setup.learn_center.dto.auth.card_type.CardTypeDetailDTO;
import neo.setup.learn_center.dto.auth.card_type.CardTypeGetDTO;
import neo.setup.learn_center.dto.auth.card_type.CardTypeUpdateDTO;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.auth.card_type.CardTypeServiceImpl;
import neo.setup.learn_center.utils.BaseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/card_type/*")
public class CardTypeControllerImpl extends AbstractController<CardTypeServiceImpl> implements CardTypeController {
    public CardTypeControllerImpl(CardTypeServiceImpl service) {
        super(service);
    }

    @Override
    public ResponseEntity<Data<String>> create(CardTypeCreateDTO DTO) {
        return new ResponseEntity<>(new Data<>("Successfully created - Auth Card Type"), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Data<String>> update(CardTypeUpdateDTO DTO) {
        return new ResponseEntity<>(new Data<>("Successfully updated - Auth Card Type"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<String>> delete(UUID code) {
        return new ResponseEntity<>(new Data<>("Successfully deleted - Auth Card Type"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<CardTypeGetDTO>> get(UUID code) {
        return service.get(code);
    }

    @Override
    public ResponseEntity<Data<CardTypeDetailDTO>> detail(UUID code) {
        return service.detail(code);
    }

    @Override
    public ResponseEntity<Data<List<CardTypeGetDTO>>> list(CardTypeCriteria criteria) {
        return service.list(criteria);
    }
}
