package neo.setup.learn_center.service.auth.payment;

import neo.setup.learn_center.criteria.auth.payment.PaymentCriteria;
import neo.setup.learn_center.dto.auth.payment.PaymentCreateDTO;
import neo.setup.learn_center.dto.auth.payment.PaymentDetailDTO;
import neo.setup.learn_center.dto.auth.payment.PaymentGetDTO;
import neo.setup.learn_center.dto.auth.payment.PaymentUpdateDTO;
import neo.setup.learn_center.entity.auth.payment.AuthPayment;
import neo.setup.learn_center.exception.exception.NotFoundException;
import neo.setup.learn_center.mapper.auth.payment.PaymentMapper;
import neo.setup.learn_center.repository.auth.payment.PaymentRepository;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.AbstractService;
import neo.setup.learn_center.validator.auth.payment.PaymentValidator;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PaymentServiceImpl extends AbstractService<PaymentValidator, PaymentMapper, PaymentRepository> implements PaymentService {
    public PaymentServiceImpl(PaymentValidator validator, PaymentMapper mapper, PaymentRepository repository) {
        super(validator, mapper, repository);
    }

    @Override
    public ResponseEntity<Data<Void>> create(PaymentCreateDTO DTO) {
        validator.validOnCreate(DTO);
        repository.save(mapper.toCreateDTO(DTO));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Void>> update(PaymentUpdateDTO DTO) {
        return null;
    }

    @Override
    public ResponseEntity<Data<Void>> delete(UUID key) {
        validator.validateKey(key);
        Optional<AuthPayment> optional = repository.getByCode(key);
        if (optional.isEmpty()) {
            throw new NotFoundException("Payment not found");
        }
        repository.deleteByCode(key);
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<PaymentGetDTO>> get(UUID key) {
        validator.validateKey(key);
        return new ResponseEntity<>(new Data<>(mapper.fromGetDTO(repository.getByCode(key).orElseThrow(() -> new NotFoundException("Payment not found")))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<PaymentDetailDTO>> detail(UUID key) {
        validator.validateKey(key);
        return new ResponseEntity<>(new Data<>(mapper.fromDetailDTO(repository.getByCode(key).orElseThrow(() -> new NotFoundException("Payment not found")))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<PaymentGetDTO>>> list(PaymentCriteria criteria) {
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize());
        return new ResponseEntity<>(new Data<>(mapper.fromGetListDTO(repository.findAll(request).stream().toList()), repository.count()), HttpStatus.OK);
    }
}
