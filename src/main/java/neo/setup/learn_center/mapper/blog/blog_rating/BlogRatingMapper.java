package neo.setup.learn_center.mapper.blog.blog_rating;

import neo.setup.learn_center.dto.blog.blog_rating.BlogRatingCreateDTO;
import neo.setup.learn_center.dto.blog.blog_rating.BlogRatingDetailDTO;
import neo.setup.learn_center.dto.blog.blog_rating.BlogRatingGetDTO;
import neo.setup.learn_center.dto.blog.blog_rating.BlogRatingUpdateDTO;
import neo.setup.learn_center.entity.blog.blog_rating.BlogRating;
import neo.setup.learn_center.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface BlogRatingMapper extends GenericMapper<BlogRatingCreateDTO, BlogRatingUpdateDTO, BlogRatingGetDTO, BlogRatingDetailDTO, BlogRating> {
}
