package neo.setup.learn_center.controller.auth.card;

import neo.setup.learn_center.controller.AbstractController;
import neo.setup.learn_center.criteria.auth.card.CardCriteria;
import neo.setup.learn_center.dto.auth.card.CardCreateDTO;
import neo.setup.learn_center.dto.auth.card.CardDetailDTO;
import neo.setup.learn_center.dto.auth.card.CardGetDTO;
import neo.setup.learn_center.dto.auth.card.CardUpdateDTO;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.auth.card.CardServiceImpl;
import neo.setup.learn_center.utils.BaseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/card/*")
public class CardControllerImpl extends AbstractController<CardServiceImpl> implements CardController {

    public CardControllerImpl(CardServiceImpl service) {
        super(service);
    }

    @Override
    public ResponseEntity<Data<String>> create(CardCreateDTO DTO) {
        service.create(DTO);
        return new ResponseEntity<>(new Data<>("Successfully created - Auth Card"), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Data<String>> update(CardUpdateDTO DTO) {
        service.update(DTO);
        return new ResponseEntity<>(new Data<>("Successfully updated - Auth Card"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<String>> delete(UUID code) {
        return new ResponseEntity<>(new Data<>("Successfully deleted - Auth Card"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<CardGetDTO>> get(UUID code) {
        return service.get(code);
    }

    @Override
    public ResponseEntity<Data<CardDetailDTO>> detail(UUID code) {
        return service.detail(code);
    }

    @Override
    public ResponseEntity<Data<List<CardGetDTO>>> list(CardCriteria criteria) {
        return service.list(criteria);
    }
}
