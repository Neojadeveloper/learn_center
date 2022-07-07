package neo.setup.learn_center.dto.blog.blog_tag;

import lombok.*;
import neo.setup.learn_center.dto.BaseDTO;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BlogTagCreateDTO implements BaseDTO {
    @Min(value = 1, message = "{blog_tag.min.size}")
    @NotNull(message = "{blog.blog_tag.blogId.required}")
    private Integer blogId;
    @Min(value = 1, message = "{blog_tag.min.size}")
    @NotNull(message = "{blog.blog_tag.tagId.required}")
    private Integer tagId;
}
