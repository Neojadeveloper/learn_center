package neo.setup.learn_center.service.system.transaction;

import neo.setup.learn_center.criteria.system.transaction.TransactionCriteria;
import neo.setup.learn_center.dto.system.transaction.TransactionCreateDTO;
import neo.setup.learn_center.dto.system.transaction.TransactionDetailDTO;
import neo.setup.learn_center.dto.system.transaction.TransactionGetDTO;
import neo.setup.learn_center.dto.system.transaction.TransactionUpdateDTO;
import neo.setup.learn_center.service.GenericCUDService;
import neo.setup.learn_center.service.GenericGLDService;

import java.util.UUID;

public interface TransactionService extends GenericCUDService<TransactionCreateDTO, TransactionUpdateDTO, UUID>, GenericGLDService<TransactionGetDTO, TransactionDetailDTO, TransactionCriteria, UUID> {
}
