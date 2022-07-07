package neo.setup.learn_center.mapper.system.transaction;

import neo.setup.learn_center.dto.system.transaction.TransactionCreateDTO;
import neo.setup.learn_center.dto.system.transaction.TransactionDetailDTO;
import neo.setup.learn_center.dto.system.transaction.TransactionGetDTO;
import neo.setup.learn_center.dto.system.transaction.TransactionUpdateDTO;
import neo.setup.learn_center.entity.system.transaction.Transaction;
import neo.setup.learn_center.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface TransactionMapper extends GenericMapper<TransactionCreateDTO, TransactionUpdateDTO, TransactionGetDTO, TransactionDetailDTO, Transaction> {
}
