package neo.setup.learn_center.controller.blog.blog_comment;

import neo.setup.learn_center.controller.AbstractController;
import neo.setup.learn_center.criteria.blog.blog_comment.BlogCommentCriteria;
import neo.setup.learn_center.dto.blog.blog_comment.BlogCommentCreateDTO;
import neo.setup.learn_center.dto.blog.blog_comment.BlogCommentDetailDTO;
import neo.setup.learn_center.dto.blog.blog_comment.BlogCommentGetDTO;
import neo.setup.learn_center.dto.blog.blog_comment.BlogCommentUpdateDTO;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.blog.blog_comment.BlogCommentServiceImpl;
import neo.setup.learn_center.utils.BaseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/blog_comment/*")
public class BlogCommentControllerImpl extends AbstractController<BlogCommentServiceImpl> implements BlogCommentController {
    public BlogCommentControllerImpl(BlogCommentServiceImpl service) {
        super(service);
    }

    @Override
    public ResponseEntity<Data<String>> create(BlogCommentCreateDTO DTO) {
        service.create(DTO);
        return new ResponseEntity<>(new Data<>("Successfully created - Blog Comment"), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Data<String>> update(BlogCommentUpdateDTO DTO) {
        service.update(DTO);
        return new ResponseEntity<>(new Data<>("Successfully updated - Blog Comment"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<String>> delete(UUID code) {
        service.delete(code);
        return new ResponseEntity<>(new Data<>("Successfully deleted - Blog Comment"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<BlogCommentGetDTO>> get(UUID code) {
        return service.get(code);
    }

    @Override
    public ResponseEntity<Data<BlogCommentDetailDTO>> detail(UUID code) {
        return service.detail(code);
    }

    @Override
    public ResponseEntity<Data<List<BlogCommentGetDTO>>> list(BlogCommentCriteria criteria) {
        return service.list(criteria);
    }
}
