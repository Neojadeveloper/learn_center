package neo.setup.learn_center.service.auth.payment;

import neo.setup.learn_center.criteria.auth.payment.PaymentCriteria;
import neo.setup.learn_center.dto.auth.payment.PaymentCreateDTO;
import neo.setup.learn_center.dto.auth.payment.PaymentDetailDTO;
import neo.setup.learn_center.dto.auth.payment.PaymentGetDTO;
import neo.setup.learn_center.dto.auth.payment.PaymentUpdateDTO;
import neo.setup.learn_center.service.GenericCUDService;
import neo.setup.learn_center.service.GenericGLDService;

import java.util.UUID;

public interface PaymentService extends GenericCUDService<PaymentCreateDTO, PaymentUpdateDTO, UUID>, GenericGLDService<PaymentGetDTO, PaymentDetailDTO, PaymentCriteria, UUID> {


}
