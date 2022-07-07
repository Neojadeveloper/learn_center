package neo.setup.learn_center.dto.blog.blog_tag;

import lombok.*;
import neo.setup.learn_center.dto.GenericDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BlogTagDetailDTO extends GenericDTO {
    private Integer blogId;
    private Integer tagId;
}
