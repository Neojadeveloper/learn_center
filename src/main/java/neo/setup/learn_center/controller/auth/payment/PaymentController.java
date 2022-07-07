package neo.setup.learn_center.controller.auth.payment;

import neo.setup.learn_center.controller.GenericCUDController;
import neo.setup.learn_center.controller.GenericGLDController;
import neo.setup.learn_center.criteria.auth.payment.PaymentCriteria;
import neo.setup.learn_center.dto.auth.payment.PaymentCreateDTO;
import neo.setup.learn_center.dto.auth.payment.PaymentDetailDTO;
import neo.setup.learn_center.dto.auth.payment.PaymentGetDTO;
import neo.setup.learn_center.dto.auth.payment.PaymentUpdateDTO;

import java.util.UUID;

public interface PaymentController extends GenericCUDController<PaymentCreateDTO, PaymentUpdateDTO, UUID>, GenericGLDController<PaymentGetDTO, PaymentDetailDTO, PaymentCriteria, UUID> {
}
