package neo.setup.learn_center.mapper.blog.blog_like;

import neo.setup.learn_center.dto.blog.blog_like.BlogLikeCreateDTO;
import neo.setup.learn_center.dto.blog.blog_like.BlogLikeDetailDTO;
import neo.setup.learn_center.dto.blog.blog_like.BlogLikeGetDTO;
import neo.setup.learn_center.dto.blog.blog_like.BlogLikeUpdateDTO;
import neo.setup.learn_center.entity.blog.blog_like.BlogLike;
import neo.setup.learn_center.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface BlogLikeMapper extends GenericMapper<BlogLikeCreateDTO, BlogLikeUpdateDTO, BlogLikeGetDTO, BlogLikeDetailDTO, BlogLike> {
}
