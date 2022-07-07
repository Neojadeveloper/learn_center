package neo.setup.learn_center.controller.blog.blog_tag;

import neo.setup.learn_center.controller.AbstractController;
import neo.setup.learn_center.criteria.blog.blog_tag.BlogTagCriteria;
import neo.setup.learn_center.dto.blog.blog_tag.BlogTagCreateDTO;
import neo.setup.learn_center.dto.blog.blog_tag.BlogTagDetailDTO;
import neo.setup.learn_center.dto.blog.blog_tag.BlogTagGetDTO;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.blog.blog_tag.BlogTagServiceImpl;
import neo.setup.learn_center.utils.BaseUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/blog_tag/*")
public class BlogTagController extends AbstractController<BlogTagServiceImpl> {
    public BlogTagController(BlogTagServiceImpl service) {
        super(service);
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<Data<Void>> create(@RequestBody BlogTagCreateDTO createDTO) {
        return service.create(createDTO);
    }

    @RequestMapping(value = "delete/{code}", method = RequestMethod.DELETE)
    public ResponseEntity<Data<Void>> delete(@PathVariable UUID code) {
        return service.delete(code);
    }

    @RequestMapping(value = "detail/{code}", method = RequestMethod.GET)
    public ResponseEntity<Data<BlogTagDetailDTO>> getWithDetail(@PathVariable UUID code) {
        return service.detail(code);
    }

    @RequestMapping(value = "{code}", method = RequestMethod.GET)
    public ResponseEntity<Data<BlogTagGetDTO>> get(@PathVariable UUID code) {
        return service.get(code);
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResponseEntity<Data<List<BlogTagGetDTO>>> getAll(@Valid BlogTagCriteria criteria) {
        return service.list(criteria);
    }
}
