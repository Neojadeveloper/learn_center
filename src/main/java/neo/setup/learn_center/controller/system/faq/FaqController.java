package neo.setup.learn_center.controller.system.faq;

import neo.setup.learn_center.controller.AbstractController;
import neo.setup.learn_center.criteria.system.faq.FaqCriteria;
import neo.setup.learn_center.dto.system.faq.FaqCreateDTO;
import neo.setup.learn_center.dto.system.faq.FaqDetailDTO;
import neo.setup.learn_center.dto.system.faq.FaqGetDTO;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.system.faq.FaqServiceImpl;
import neo.setup.learn_center.utils.BaseUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/faq/*")
public class FaqController extends AbstractController<FaqServiceImpl> {
    public FaqController(FaqServiceImpl service) {
        super(service);
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<Data<Void>> create(@RequestBody FaqCreateDTO createDTO) {
        return service.create(createDTO);
    }

    @RequestMapping(value = "delete/{code}", method = RequestMethod.DELETE)
    public ResponseEntity<Data<Void>> delete(@PathVariable UUID code) {
        return service.delete(code);
    }

    @RequestMapping(value = "detail/{code}", method = RequestMethod.GET)
    public ResponseEntity<Data<FaqDetailDTO>> getWithDetail(@PathVariable UUID code) {
        return service.detail(code);
    }

    @RequestMapping(value = "{code}", method = RequestMethod.GET)
    public ResponseEntity<Data<FaqGetDTO>> get(@PathVariable UUID code) {
        return service.get(code);
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResponseEntity<Data<List<FaqGetDTO>>> getAll(@Valid FaqCriteria criteria) {
        return service.list(criteria);
    }
}
