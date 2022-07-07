package neo.setup.learn_center.dto.blog.blog_comment;

import lombok.*;
import neo.setup.learn_center.dto.GenericDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BlogCommentGetDTO extends GenericDTO {
    private Integer blogId;
    private String message;
}
