package neo.setup.learn_center.controller.system.transaction_status;

import neo.setup.learn_center.controller.GenericCUDController;
import neo.setup.learn_center.controller.GenericGLDController;
import neo.setup.learn_center.criteria.system.transaction_status.TransactionStatusCriteria;
import neo.setup.learn_center.dto.system.transaction_status.TransactionStatusCreateDTO;
import neo.setup.learn_center.dto.system.transaction_status.TransactionStatusDetailDTO;
import neo.setup.learn_center.dto.system.transaction_status.TransactionStatusGetDTO;
import neo.setup.learn_center.dto.system.transaction_status.TransactionStatusUpdateDTO;

import java.util.UUID;

public interface TransactionStatusController extends GenericCUDController<TransactionStatusCreateDTO, TransactionStatusUpdateDTO, UUID>, GenericGLDController<TransactionStatusGetDTO, TransactionStatusDetailDTO, TransactionStatusCriteria, UUID> {
}
