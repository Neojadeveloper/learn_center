package neo.setup.learn_center.controller.auth.language;

import neo.setup.learn_center.controller.AbstractController;
import neo.setup.learn_center.criteria.auth.language.LanguageCriteria;
import neo.setup.learn_center.dto.auth.language.LanguageCreateDTO;
import neo.setup.learn_center.dto.auth.language.LanguageDetailDTO;
import neo.setup.learn_center.dto.auth.language.LanguageGetDTO;
import neo.setup.learn_center.dto.auth.language.LanguageUpdateDTO;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.auth.language.LanguageServiceImpl;
import neo.setup.learn_center.utils.BaseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/language/*")
public class LanguageControllerImpl extends AbstractController<LanguageServiceImpl> implements LanguageController {

    public LanguageControllerImpl(LanguageServiceImpl service) {
        super(service);
    }

    @Override
    public ResponseEntity<Data<String>> create(LanguageCreateDTO DTO) {
        return new ResponseEntity<>(new Data<>("Successfully created - Language"), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Data<String>> update(LanguageUpdateDTO DTO) {
        return new ResponseEntity<>(new Data<>("Successfully update - Language"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<String>> delete(UUID code) {
        return new ResponseEntity<>(new Data<>("Successfully deleted - Language"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<LanguageGetDTO>> get(UUID code) {
        return service.get(code);
    }

    @Override
    public ResponseEntity<Data<LanguageDetailDTO>> detail(UUID code) {
        return service.detail(code);
    }

    @Override
    public ResponseEntity<Data<List<LanguageGetDTO>>> list(LanguageCriteria criteria) {
        return service.list(criteria);
    }
}
