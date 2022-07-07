package neo.setup.learn_center.mapper.blog.blog_comment;

import neo.setup.learn_center.dto.blog.blog_comment.BlogCommentCreateDTO;
import neo.setup.learn_center.dto.blog.blog_comment.BlogCommentDetailDTO;
import neo.setup.learn_center.dto.blog.blog_comment.BlogCommentGetDTO;
import neo.setup.learn_center.dto.blog.blog_comment.BlogCommentUpdateDTO;
import neo.setup.learn_center.entity.blog.blog_comment.BlogComment;
import neo.setup.learn_center.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface BlogCommentMapper extends GenericMapper<BlogCommentCreateDTO, BlogCommentUpdateDTO, BlogCommentGetDTO, BlogCommentDetailDTO, BlogComment> {
}
