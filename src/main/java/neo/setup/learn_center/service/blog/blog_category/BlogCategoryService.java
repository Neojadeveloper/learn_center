package neo.setup.learn_center.service.blog.blog_category;

import neo.setup.learn_center.criteria.blog.blog_category.BlogCategoryCriteria;
import neo.setup.learn_center.dto.blog.blog_category.BlogCategoryCreateDTO;
import neo.setup.learn_center.dto.blog.blog_category.BlogCategoryDetailDTO;
import neo.setup.learn_center.dto.blog.blog_category.BlogCategoryGetDTO;
import neo.setup.learn_center.dto.blog.blog_category.BlogCategoryUpdateDTO;
import neo.setup.learn_center.service.GenericCUDService;
import neo.setup.learn_center.service.GenericGLDService;

import java.util.UUID;

public interface BlogCategoryService extends GenericCUDService<BlogCategoryCreateDTO, BlogCategoryUpdateDTO, UUID>, GenericGLDService<BlogCategoryGetDTO, BlogCategoryDetailDTO, BlogCategoryCriteria, UUID> {
}
