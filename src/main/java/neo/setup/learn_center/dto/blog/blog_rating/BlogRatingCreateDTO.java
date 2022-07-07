package neo.setup.learn_center.dto.blog.blog_rating;

import lombok.*;
import neo.setup.learn_center.dto.BaseDTO;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BlogRatingCreateDTO implements BaseDTO {
    @Min(value = 1, message = "{blog_rating.min.size}")
    @NotNull(message = "{blog.blog_rating.blogId.required}")
    private Integer blogId;
    @Min(value = 1, message = "{blog_rating.min.size}")
    @NotNull(message = "{blog.blog_rating.views.required}")
    private Integer views;
    @Min(value = 1, message = "{blog_rating.min.size}")
    @NotNull(message = "{blog.blog_rating.stars.required}")
    private Integer stars;
}
