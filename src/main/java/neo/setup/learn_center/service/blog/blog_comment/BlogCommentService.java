package neo.setup.learn_center.service.blog.blog_comment;

import neo.setup.learn_center.criteria.blog.blog_comment.BlogCommentCriteria;
import neo.setup.learn_center.dto.blog.blog_comment.BlogCommentCreateDTO;
import neo.setup.learn_center.dto.blog.blog_comment.BlogCommentDetailDTO;
import neo.setup.learn_center.dto.blog.blog_comment.BlogCommentGetDTO;
import neo.setup.learn_center.dto.blog.blog_comment.BlogCommentUpdateDTO;
import neo.setup.learn_center.service.GenericCUDService;
import neo.setup.learn_center.service.GenericGLDService;

import java.util.UUID;

public interface BlogCommentService extends GenericCUDService<BlogCommentCreateDTO, BlogCommentUpdateDTO, UUID>, GenericGLDService<BlogCommentGetDTO, BlogCommentDetailDTO, BlogCommentCriteria, UUID> {
}
