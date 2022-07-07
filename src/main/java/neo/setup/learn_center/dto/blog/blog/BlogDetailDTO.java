package neo.setup.learn_center.dto.blog.blog;

import lombok.*;
import neo.setup.learn_center.dto.GenericDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BlogDetailDTO extends GenericDTO {
    private String title;
    private String description;
    private String content;
    private String image;
    private Integer categoryId;
    private boolean isPublished;
}
