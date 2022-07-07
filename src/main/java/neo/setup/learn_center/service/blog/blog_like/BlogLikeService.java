package neo.setup.learn_center.service.blog.blog_like;

import neo.setup.learn_center.criteria.blog.blog_like.BlogLikeCriteria;
import neo.setup.learn_center.dto.blog.blog_like.BlogLikeCreateDTO;
import neo.setup.learn_center.dto.blog.blog_like.BlogLikeDetailDTO;
import neo.setup.learn_center.dto.blog.blog_like.BlogLikeGetDTO;
import neo.setup.learn_center.dto.blog.blog_like.BlogLikeUpdateDTO;
import neo.setup.learn_center.service.GenericCUDService;
import neo.setup.learn_center.service.GenericGLDService;

import java.util.UUID;

public interface BlogLikeService extends GenericCUDService<BlogLikeCreateDTO, BlogLikeUpdateDTO, UUID>, GenericGLDService<BlogLikeGetDTO, BlogLikeDetailDTO, BlogLikeCriteria, UUID> {
}
