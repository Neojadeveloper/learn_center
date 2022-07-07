package neo.setup.learn_center.mapper.blog.blog_category;

import neo.setup.learn_center.dto.blog.blog_category.BlogCategoryCreateDTO;
import neo.setup.learn_center.dto.blog.blog_category.BlogCategoryDetailDTO;
import neo.setup.learn_center.dto.blog.blog_category.BlogCategoryGetDTO;
import neo.setup.learn_center.dto.blog.blog_category.BlogCategoryUpdateDTO;
import neo.setup.learn_center.entity.blog.blog_category.BlogCategory;
import neo.setup.learn_center.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface BlogCategoryMapper extends GenericMapper<BlogCategoryCreateDTO, BlogCategoryUpdateDTO, BlogCategoryGetDTO, BlogCategoryDetailDTO, BlogCategory> {
}
