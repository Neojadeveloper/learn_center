package neo.setup.learn_center.dto.blog.blog_like;

import lombok.*;
import neo.setup.learn_center.dto.BaseDTO;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BlogLikeCreateDTO implements BaseDTO {
    @Min(value = 1, message = "{blog.min.size}")
    @NotNull(message = "{blog.blog_like.blogId.required}")
    private Integer blogId;
    @Min(value = 1, message = "{blog.min.size}")
    @NotNull(message = "{blog.blog_like.userId.required}")
    private Integer userId;
}
