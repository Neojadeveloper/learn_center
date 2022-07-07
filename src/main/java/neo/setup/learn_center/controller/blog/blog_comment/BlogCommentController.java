package neo.setup.learn_center.controller.blog.blog_comment;

import neo.setup.learn_center.controller.GenericCUDController;
import neo.setup.learn_center.controller.GenericGLDController;
import neo.setup.learn_center.criteria.blog.blog_comment.BlogCommentCriteria;
import neo.setup.learn_center.dto.blog.blog_comment.BlogCommentCreateDTO;
import neo.setup.learn_center.dto.blog.blog_comment.BlogCommentDetailDTO;
import neo.setup.learn_center.dto.blog.blog_comment.BlogCommentGetDTO;
import neo.setup.learn_center.dto.blog.blog_comment.BlogCommentUpdateDTO;

import java.util.UUID;

public interface BlogCommentController extends GenericCUDController<BlogCommentCreateDTO, BlogCommentUpdateDTO, UUID>, GenericGLDController<BlogCommentGetDTO, BlogCommentDetailDTO, BlogCommentCriteria, UUID> {
}
