package neo.setup.learn_center.controller.blog.blog;

import neo.setup.learn_center.controller.GenericCUDController;
import neo.setup.learn_center.controller.GenericGLDController;
import neo.setup.learn_center.criteria.blog.blog.BlogCriteria;
import neo.setup.learn_center.dto.blog.blog.BlogCreateDTO;
import neo.setup.learn_center.dto.blog.blog.BlogDetailDTO;
import neo.setup.learn_center.dto.blog.blog.BlogGetDTO;
import neo.setup.learn_center.dto.blog.blog.BlogUpdateDTO;

import java.util.UUID;

public interface BlogController extends GenericCUDController<BlogCreateDTO, BlogUpdateDTO, UUID>, GenericGLDController<BlogGetDTO, BlogDetailDTO, BlogCriteria, UUID> {
}
