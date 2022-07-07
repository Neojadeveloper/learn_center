package neo.setup.learn_center.mapper.blog.blog_tag;

import neo.setup.learn_center.dto.blog.blog_tag.BlogTagCreateDTO;
import neo.setup.learn_center.dto.blog.blog_tag.BlogTagDetailDTO;
import neo.setup.learn_center.dto.blog.blog_tag.BlogTagGetDTO;
import neo.setup.learn_center.dto.blog.blog_tag.BlogTagUpdateDTO;
import neo.setup.learn_center.entity.blog.blog_tag.BlogTag;
import neo.setup.learn_center.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface BlogTagMapper extends GenericMapper<BlogTagCreateDTO, BlogTagUpdateDTO, BlogTagGetDTO, BlogTagDetailDTO, BlogTag> {
}
