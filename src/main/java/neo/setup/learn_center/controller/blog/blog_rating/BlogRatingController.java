package neo.setup.learn_center.controller.blog.blog_rating;

import neo.setup.learn_center.controller.GenericCUDController;
import neo.setup.learn_center.controller.GenericGLDController;
import neo.setup.learn_center.criteria.blog.blog_rating.BlogRatingCriteria;
import neo.setup.learn_center.dto.blog.blog_rating.BlogRatingCreateDTO;
import neo.setup.learn_center.dto.blog.blog_rating.BlogRatingDetailDTO;
import neo.setup.learn_center.dto.blog.blog_rating.BlogRatingGetDTO;
import neo.setup.learn_center.dto.blog.blog_rating.BlogRatingUpdateDTO;

import java.util.UUID;

public interface BlogRatingController extends GenericCUDController<BlogRatingCreateDTO, BlogRatingUpdateDTO, UUID>, GenericGLDController<BlogRatingGetDTO, BlogRatingDetailDTO, BlogRatingCriteria, UUID> {
}
