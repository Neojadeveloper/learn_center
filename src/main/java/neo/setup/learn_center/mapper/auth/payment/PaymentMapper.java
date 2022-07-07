package neo.setup.learn_center.mapper.auth.payment;

import neo.setup.learn_center.dto.auth.payment.PaymentCreateDTO;
import neo.setup.learn_center.dto.auth.payment.PaymentDetailDTO;
import neo.setup.learn_center.dto.auth.payment.PaymentGetDTO;
import neo.setup.learn_center.dto.auth.payment.PaymentUpdateDTO;
import neo.setup.learn_center.entity.auth.payment.AuthPayment;
import neo.setup.learn_center.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface PaymentMapper extends GenericMapper<PaymentCreateDTO, PaymentUpdateDTO, PaymentGetDTO, PaymentDetailDTO, AuthPayment> {
}
