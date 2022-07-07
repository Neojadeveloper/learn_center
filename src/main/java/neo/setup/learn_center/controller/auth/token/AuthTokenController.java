package neo.setup.learn_center.controller.auth.token;

import neo.setup.learn_center.controller.AbstractController;
import neo.setup.learn_center.criteria.auth.token.AuthTokenCriteria;
import neo.setup.learn_center.dto.auth.token.AuthTokenDetailDTO;
import neo.setup.learn_center.dto.auth.token.AuthTokenGetDTO;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.auth.token.AuthTokenServiceImpl;
import neo.setup.learn_center.utils.BaseUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/token/*")
public class AuthTokenController extends AbstractController<AuthTokenServiceImpl> {
    public AuthTokenController(AuthTokenServiceImpl service) {
        super(service);
    }

    @RequestMapping(value = "refresh-token", method = RequestMethod.GET)
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        service.refreshToken(request, response);
    }

    @RequestMapping(value = "delete/{code}", method = RequestMethod.DELETE)
    public ResponseEntity<Data<Void>> delete(@PathVariable UUID code) {
        return service.delete(code);
    }

    @RequestMapping(value = "detail/{code}", method = RequestMethod.GET)
    public ResponseEntity<Data<AuthTokenDetailDTO>> getWithDetail(@PathVariable UUID code) {
        return service.detail(code);
    }

    @RequestMapping(value = "{code}", method = RequestMethod.GET)
    public ResponseEntity<Data<AuthTokenGetDTO>> get(@PathVariable UUID code) {
        return service.get(code);
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResponseEntity<Data<List<AuthTokenGetDTO>>> getAll(@Valid AuthTokenCriteria criteria) {
        return service.list(criteria);
    }
}
