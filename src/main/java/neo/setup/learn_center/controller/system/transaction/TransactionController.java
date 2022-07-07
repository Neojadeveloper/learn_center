package neo.setup.learn_center.controller.system.transaction;

import neo.setup.learn_center.controller.AbstractController;
import neo.setup.learn_center.criteria.system.transaction.TransactionCriteria;
import neo.setup.learn_center.dto.system.transaction.TransactionCreateDTO;
import neo.setup.learn_center.dto.system.transaction.TransactionDetailDTO;
import neo.setup.learn_center.dto.system.transaction.TransactionGetDTO;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.system.transaction.TransactionServiceImpl;
import neo.setup.learn_center.utils.BaseUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/transaction/*")
public class TransactionController extends AbstractController<TransactionServiceImpl> {
    public TransactionController(TransactionServiceImpl service) {
        super(service);
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<Data<Void>> create(@RequestBody TransactionCreateDTO createDTO) {
        return service.create(createDTO);
    }

    @RequestMapping(value = "delete/{code}", method = RequestMethod.DELETE)
    public ResponseEntity<Data<Void>> delete(@PathVariable UUID code) {
        return service.delete(code);
    }

    @RequestMapping(value = "detail/{code}", method = RequestMethod.GET)
    public ResponseEntity<Data<TransactionDetailDTO>> getWithDetail(@PathVariable UUID code) {
        return service.detail(code);
    }

    @RequestMapping(value = "{code}", method = RequestMethod.GET)
    public ResponseEntity<Data<TransactionGetDTO>> get(@PathVariable UUID code) {
        return service.get(code);
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResponseEntity<Data<List<TransactionGetDTO>>> getAll(@Valid TransactionCriteria criteria) {
        return service.list(criteria);
    }
}
