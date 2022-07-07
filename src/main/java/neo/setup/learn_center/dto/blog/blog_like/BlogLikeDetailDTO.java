package neo.setup.learn_center.dto.blog.blog_like;

import lombok.*;
import neo.setup.learn_center.dto.GenericDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BlogLikeDetailDTO extends GenericDTO {
    private Integer blogId;
    private Integer userId;
}
