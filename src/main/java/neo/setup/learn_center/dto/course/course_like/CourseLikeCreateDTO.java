package neo.setup.learn_center.dto.course.course_like;

import lombok.*;
import neo.setup.learn_center.dto.BaseDTO;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CourseLikeCreateDTO implements BaseDTO {
    @NotNull(message = "{course.course.like.course_id.required}")
    private Integer courseId;

    @NotNull(message = "{course.course.like.user_id.required}")
    private Integer userId;
}
