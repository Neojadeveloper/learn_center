package neo.setup.learn_center.service.system.transaction_status;

import neo.setup.learn_center.criteria.system.transaction_status.TransactionStatusCriteria;
import neo.setup.learn_center.dto.system.transaction_status.TransactionStatusCreateDTO;
import neo.setup.learn_center.dto.system.transaction_status.TransactionStatusDetailDTO;
import neo.setup.learn_center.dto.system.transaction_status.TransactionStatusGetDTO;
import neo.setup.learn_center.dto.system.transaction_status.TransactionStatusUpdateDTO;
import neo.setup.learn_center.service.GenericCUDService;
import neo.setup.learn_center.service.GenericGLDService;

import java.util.UUID;

public interface TransactionStatusService extends GenericCUDService<TransactionStatusCreateDTO, TransactionStatusUpdateDTO, UUID>, GenericGLDService<TransactionStatusGetDTO, TransactionStatusDetailDTO, TransactionStatusCriteria, UUID> {
}
