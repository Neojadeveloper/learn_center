package neo.setup.learn_center.controller.auth.role;

import neo.setup.learn_center.controller.AbstractController;
import neo.setup.learn_center.criteria.auth.role.RoleCriteria;
import neo.setup.learn_center.dto.auth.role.RoleCreateDTO;
import neo.setup.learn_center.dto.auth.role.RoleDetailDTO;
import neo.setup.learn_center.dto.auth.role.RoleGetDTO;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.auth.role.RoleServiceImpl;
import neo.setup.learn_center.utils.BaseUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/role/*")
public class RoleController extends AbstractController<RoleServiceImpl> {

    public RoleController(RoleServiceImpl service) {
        super(service);
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<Data<Void>> create(@RequestBody RoleCreateDTO createDTO) {
        return service.create(createDTO);
    }

    @RequestMapping(value = "delete/{code}", method = RequestMethod.DELETE)
    public ResponseEntity<Data<Void>> delete(@PathVariable UUID code) {
        return service.delete(code);
    }

    @RequestMapping(value = "detail/{code}", method = RequestMethod.GET)
    public ResponseEntity<Data<RoleDetailDTO>> getWithDetail(@PathVariable UUID code) {
        return service.detail(code);
    }

    @RequestMapping(value = "{code}", method = RequestMethod.GET)
    public ResponseEntity<Data<RoleGetDTO>> get(@PathVariable UUID code) {
        return service.get(code);
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResponseEntity<Data<List<RoleGetDTO>>> getAll(@Valid RoleCriteria criteria) {
        return service.list(criteria);
    }
}
