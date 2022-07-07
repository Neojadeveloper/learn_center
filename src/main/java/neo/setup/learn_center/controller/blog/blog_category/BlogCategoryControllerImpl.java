package neo.setup.learn_center.controller.blog.blog_category;

import neo.setup.learn_center.controller.AbstractController;
import neo.setup.learn_center.criteria.blog.blog_category.BlogCategoryCriteria;
import neo.setup.learn_center.dto.blog.blog_category.BlogCategoryCreateDTO;
import neo.setup.learn_center.dto.blog.blog_category.BlogCategoryDetailDTO;
import neo.setup.learn_center.dto.blog.blog_category.BlogCategoryGetDTO;
import neo.setup.learn_center.dto.blog.blog_category.BlogCategoryUpdateDTO;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.blog.blog_category.BlogCategoryServiceImpl;
import neo.setup.learn_center.utils.BaseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/blog-category/*")
public class BlogCategoryControllerImpl extends AbstractController<BlogCategoryServiceImpl> implements BlogCategoryController {
    public BlogCategoryControllerImpl(BlogCategoryServiceImpl service) {
        super(service);
    }

    @Override
    public ResponseEntity<Data<String>> create(BlogCategoryCreateDTO DTO) {
        service.create(DTO);
        return new ResponseEntity<>(new Data<>("Successfully created - Blog Category"), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Data<String>> update(BlogCategoryUpdateDTO DTO) {
        service.update(DTO);
        return new ResponseEntity<>(new Data<>("Successfully updated - Blog Category"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<String>> delete(UUID code) {
        service.delete(code);
        return new ResponseEntity<>(new Data<>("Successfully deleted - Blog Category"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<BlogCategoryGetDTO>> get(UUID code) {
        return service.get(code);
    }

    @Override
    public ResponseEntity<Data<BlogCategoryDetailDTO>> detail(UUID code) {
        return service.detail(code);
    }

    @Override
    public ResponseEntity<Data<List<BlogCategoryGetDTO>>> list(BlogCategoryCriteria criteria) {
        return service.list(criteria);
    }
}
