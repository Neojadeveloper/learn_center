package neo.setup.learn_center.dto.blog.blog_rating;

import lombok.*;
import neo.setup.learn_center.dto.GenericDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BlogRatingDetailDTO extends GenericDTO {
    private Integer blogId;
    private Integer views;
    private Integer stars;
}
