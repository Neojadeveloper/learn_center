package neo.setup.learn_center.controller.auth.teacher_skills;

import neo.setup.learn_center.controller.AbstractController;
import neo.setup.learn_center.criteria.auth.teacher_skills.TeacherSkillsCriteria;
import neo.setup.learn_center.dto.auth.teacher_skills.TeacherSkillsCreateDTO;
import neo.setup.learn_center.dto.auth.teacher_skills.TeacherSkillsDetailDTO;
import neo.setup.learn_center.dto.auth.teacher_skills.TeacherSkillsGetDTO;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.auth.teacher_skills.TeacherSkillsServiceImpl;
import neo.setup.learn_center.utils.BaseUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/teacher_skills/*")
public class TeacherSkillsController extends AbstractController<TeacherSkillsServiceImpl> {

    public TeacherSkillsController(TeacherSkillsServiceImpl service) {
        super(service);
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<Data<Void>> create(@RequestBody TeacherSkillsCreateDTO createDTO) {
        return service.create(createDTO);
    }

    @RequestMapping(value = "delete/{code}", method = RequestMethod.DELETE)
    public ResponseEntity<Data<Void>> delete(@PathVariable UUID code) {
        return service.delete(code);
    }

    @RequestMapping(value = "detail/{code}", method = RequestMethod.GET)
    public ResponseEntity<Data<TeacherSkillsDetailDTO>> getWithDetail(@PathVariable UUID code) {
        return service.detail(code);
    }

    @RequestMapping(value = "{code}", method = RequestMethod.GET)
    public ResponseEntity<Data<TeacherSkillsGetDTO>> get(@PathVariable UUID code) {
        return service.get(code);
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResponseEntity<Data<List<TeacherSkillsGetDTO>>> getAll(@Valid TeacherSkillsCriteria criteria) {
        return service.list(criteria);
    }
}
