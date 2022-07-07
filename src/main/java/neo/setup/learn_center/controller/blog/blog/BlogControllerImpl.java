package neo.setup.learn_center.controller.blog.blog;

import neo.setup.learn_center.controller.AbstractController;
import neo.setup.learn_center.criteria.blog.blog.BlogCriteria;
import neo.setup.learn_center.dto.blog.blog.BlogCreateDTO;
import neo.setup.learn_center.dto.blog.blog.BlogDetailDTO;
import neo.setup.learn_center.dto.blog.blog.BlogGetDTO;
import neo.setup.learn_center.dto.blog.blog.BlogUpdateDTO;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.blog.blog.BlogServiceImpl;
import neo.setup.learn_center.utils.BaseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/blog/*")
public class BlogControllerImpl extends AbstractController<BlogServiceImpl> implements BlogController {

    public BlogControllerImpl(BlogServiceImpl service) {
        super(service);
    }

    @Override
    public ResponseEntity<Data<String>> create(BlogCreateDTO DTO) {
        service.create(DTO);
        return new ResponseEntity<>(new Data<>("Successfully created - Blog"), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Data<String>> update(BlogUpdateDTO DTO) {
        service.update(DTO);
        return new ResponseEntity<>(new Data<>("Successfully updated - Blog"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<String>> delete(UUID code) {
        service.delete(code);
        return new ResponseEntity<>(new Data<>("Successfully deleted - Blog"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<BlogGetDTO>> get(UUID code) {
        return service.get(code);
    }

    @Override
    public ResponseEntity<Data<BlogDetailDTO>> detail(UUID code) {
        return service.detail(code);
    }

    @Override
    public ResponseEntity<Data<List<BlogGetDTO>>> list(BlogCriteria criteria) {
        return service.list(criteria);
    }
}
