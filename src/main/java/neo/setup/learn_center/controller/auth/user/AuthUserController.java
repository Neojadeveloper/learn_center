package neo.setup.learn_center.controller.auth.user;

import neo.setup.learn_center.controller.AbstractController;
import neo.setup.learn_center.criteria.auth.user.AuthUserCriteria;
import neo.setup.learn_center.dto.auth.user.AuthUserCreateDTO;
import neo.setup.learn_center.dto.auth.user.AuthUserDetailDTO;
import neo.setup.learn_center.dto.auth.user.AuthUserGetDTO;
import neo.setup.learn_center.dto.auth.user.AuthUserLoginDTO;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.auth.user.AuthUserServiceImpl;
import neo.setup.learn_center.utils.BaseUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/auth/")
public class AuthUserController extends AbstractController<AuthUserServiceImpl> {
    public AuthUserController(AuthUserServiceImpl service) {
        super(service);
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Object login(@Valid @RequestBody AuthUserLoginDTO dto) {
        HttpEntity<AuthUserLoginDTO> entity = new HttpEntity<>(dto);
        ResponseEntity<Object> exchange = BaseUtils.TEMPLATE.exchange("http://localhost:80/api/v1/login", HttpMethod.POST, entity, Object.class);
        return exchange.getBody();
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResponseEntity<Data<String>> register(@Valid @RequestBody AuthUserCreateDTO dto) {
        service.create(dto);
        return new ResponseEntity<>(new Data<>("Successfully Registered"), HttpStatus.OK);
    }

    @RequestMapping(value = "delete/{code}", method = RequestMethod.DELETE)
    public ResponseEntity<Data<String>> delete(@PathVariable UUID code) {
        service.delete(code);
        return new ResponseEntity<>(new Data<>("Successfully deleted - Auth User"), HttpStatus.OK);
    }

    @RequestMapping(value = "detail/{code}", method = RequestMethod.GET)
    public ResponseEntity<Data<AuthUserDetailDTO>> getWithDetail(@PathVariable UUID code) {
        return service.detail(code);
    }

    @RequestMapping(value = "{code}", method = RequestMethod.GET)
    public ResponseEntity<Data<AuthUserGetDTO>> get(@PathVariable UUID code) {
        return service.get(code);
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResponseEntity<Data<List<AuthUserGetDTO>>> getAll(@Valid AuthUserCriteria criteria) {
        return service.list(criteria);
    }
}
