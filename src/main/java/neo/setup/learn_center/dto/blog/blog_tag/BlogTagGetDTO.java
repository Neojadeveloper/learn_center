package neo.setup.learn_center.dto.blog.blog_tag;

import lombok.*;
import neo.setup.learn_center.dto.GenericDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BlogTagGetDTO extends GenericDTO {
    private Integer blogId;
    private Integer tagId;
}
