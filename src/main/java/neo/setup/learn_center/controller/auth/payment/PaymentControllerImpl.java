package neo.setup.learn_center.controller.auth.payment;

import neo.setup.learn_center.controller.AbstractController;
import neo.setup.learn_center.criteria.auth.payment.PaymentCriteria;
import neo.setup.learn_center.dto.auth.payment.PaymentCreateDTO;
import neo.setup.learn_center.dto.auth.payment.PaymentDetailDTO;
import neo.setup.learn_center.dto.auth.payment.PaymentGetDTO;
import neo.setup.learn_center.dto.auth.payment.PaymentUpdateDTO;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.auth.payment.PaymentServiceImpl;
import neo.setup.learn_center.utils.BaseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/payment/*")
public class PaymentControllerImpl extends AbstractController<PaymentServiceImpl> implements PaymentController {
    public PaymentControllerImpl(PaymentServiceImpl service) {
        super(service);
    }

    @Override
    public ResponseEntity<Data<String>> create(PaymentCreateDTO DTO) {
        service.create(DTO);
        return new ResponseEntity<>(new Data<>("Successfully created - Payment"), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Data<String>> update(PaymentUpdateDTO DTO) {
        service.update(DTO);
        return new ResponseEntity<>(new Data<>("Successfully updated - Payment"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<String>> delete(UUID code) {
        service.delete(code);
        return new ResponseEntity<>(new Data<>("Successfully deleted - Payment"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<PaymentGetDTO>> get(UUID code) {
        return service.get(code);
    }

    @Override
    public ResponseEntity<Data<PaymentDetailDTO>> detail(UUID code) {
        return service.detail(code);
    }

    @Override
    public ResponseEntity<Data<List<PaymentGetDTO>>> list(PaymentCriteria criteria) {
        return service.list(criteria);
    }
}
