package neo.setup.learn_center.mapper.system.transaction_status;

import neo.setup.learn_center.dto.system.transaction_status.TransactionStatusCreateDTO;
import neo.setup.learn_center.dto.system.transaction_status.TransactionStatusDetailDTO;
import neo.setup.learn_center.dto.system.transaction_status.TransactionStatusGetDTO;
import neo.setup.learn_center.dto.system.transaction_status.TransactionStatusUpdateDTO;
import neo.setup.learn_center.entity.system.transaction_status.TransactionStatus;
import neo.setup.learn_center.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface TransactionStatusMapper extends GenericMapper<TransactionStatusCreateDTO, TransactionStatusUpdateDTO, TransactionStatusGetDTO, TransactionStatusDetailDTO, TransactionStatus> {
}
