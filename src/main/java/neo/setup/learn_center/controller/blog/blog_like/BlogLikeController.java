package neo.setup.learn_center.controller.blog.blog_like;

import neo.setup.learn_center.controller.AbstractController;
import neo.setup.learn_center.criteria.blog.blog_like.BlogLikeCriteria;
import neo.setup.learn_center.dto.blog.blog_like.BlogLikeCreateDTO;
import neo.setup.learn_center.dto.blog.blog_like.BlogLikeDetailDTO;
import neo.setup.learn_center.dto.blog.blog_like.BlogLikeGetDTO;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.blog.blog_like.BlogLikeServiceImpl;
import neo.setup.learn_center.utils.BaseUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/blog_like/*")
public class BlogLikeController extends AbstractController<BlogLikeServiceImpl>  {

    public BlogLikeController(BlogLikeServiceImpl service) {
        super(service);
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<Data<Void>> create(@RequestBody BlogLikeCreateDTO createDTO) {
        return service.create(createDTO);
    }

    @RequestMapping(value = "delete/{code}", method = RequestMethod.DELETE)
    public ResponseEntity<Data<Void>> delete(@PathVariable UUID code) {
        return service.delete(code);
    }

    @RequestMapping(value = "detail/{code}", method = RequestMethod.GET)
    public ResponseEntity<Data<BlogLikeDetailDTO>> getWithDetail(@PathVariable UUID code) {
        return service.detail(code);
    }

    @RequestMapping(value = "{code}", method = RequestMethod.GET)
    public ResponseEntity<Data<BlogLikeGetDTO>> get(@PathVariable UUID code) {
        return service.get(code);
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResponseEntity<Data<List<BlogLikeGetDTO>>> getAll(@Valid BlogLikeCriteria criteria) {
        return service.list(criteria);
    }
}
