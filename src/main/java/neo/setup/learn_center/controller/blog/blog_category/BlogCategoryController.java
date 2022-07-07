package neo.setup.learn_center.controller.blog.blog_category;

import neo.setup.learn_center.controller.GenericCUDController;
import neo.setup.learn_center.controller.GenericGLDController;
import neo.setup.learn_center.criteria.blog.blog_category.BlogCategoryCriteria;
import neo.setup.learn_center.dto.blog.blog_category.BlogCategoryCreateDTO;
import neo.setup.learn_center.dto.blog.blog_category.BlogCategoryDetailDTO;
import neo.setup.learn_center.dto.blog.blog_category.BlogCategoryGetDTO;
import neo.setup.learn_center.dto.blog.blog_category.BlogCategoryUpdateDTO;

import java.util.UUID;

public interface BlogCategoryController extends GenericCUDController<BlogCategoryCreateDTO, BlogCategoryUpdateDTO, UUID>, GenericGLDController<BlogCategoryGetDTO, BlogCategoryDetailDTO, BlogCategoryCriteria, UUID> {
}
