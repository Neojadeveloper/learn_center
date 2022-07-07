package neo.setup.learn_center.mapper.blog.blog;

import neo.setup.learn_center.dto.blog.blog.BlogCreateDTO;
import neo.setup.learn_center.dto.blog.blog.BlogDetailDTO;
import neo.setup.learn_center.dto.blog.blog.BlogGetDTO;
import neo.setup.learn_center.dto.blog.blog.BlogUpdateDTO;
import neo.setup.learn_center.entity.blog.blog.Blog;
import neo.setup.learn_center.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface BlogMapper extends GenericMapper<BlogCreateDTO, BlogUpdateDTO, BlogGetDTO, BlogDetailDTO, Blog> {
}
