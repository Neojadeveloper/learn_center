package neo.setup.learn_center.service.blog.blog_rating;

import neo.setup.learn_center.criteria.blog.blog_rating.BlogRatingCriteria;
import neo.setup.learn_center.dto.blog.blog_rating.BlogRatingCreateDTO;
import neo.setup.learn_center.dto.blog.blog_rating.BlogRatingDetailDTO;
import neo.setup.learn_center.dto.blog.blog_rating.BlogRatingGetDTO;
import neo.setup.learn_center.dto.blog.blog_rating.BlogRatingUpdateDTO;
import neo.setup.learn_center.service.GenericCUDService;
import neo.setup.learn_center.service.GenericGLDService;

import java.util.UUID;

public interface BlogRatingService extends GenericCUDService<BlogRatingCreateDTO, BlogRatingUpdateDTO, UUID>, GenericGLDService<BlogRatingGetDTO, BlogRatingDetailDTO, BlogRatingCriteria, UUID> {
}
