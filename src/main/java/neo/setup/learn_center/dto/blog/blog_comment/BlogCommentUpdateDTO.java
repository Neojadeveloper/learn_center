package neo.setup.learn_center.dto.blog.blog_comment;

import lombok.*;
import neo.setup.learn_center.dto.GenericDTO;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BlogCommentUpdateDTO extends GenericDTO {
    @Min(value = 1, message = "{blog.blog_comment.blogId.min.size}")
    @NotNull(message = "{blog.blog_comment.blogId.required}")
    private Integer blogId;
    @NotBlank(message = "{blog.blog_comment.message.required}")
    @Size(min = 3, max = 120, message = "{blog.blog_comment.message.size}")
    private String message;
}
