package neo.setup.learn_center.dto.course.course_tag;

import lombok.*;
import neo.setup.learn_center.dto.BaseDTO;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CourseTagCreateDTO implements BaseDTO {
    @NotNull(message = "{course.course.tag.course_id.required}")
    private Integer courseId;

    @NotNull(message = "{course.course.tag.tag_id.required}")
    private Integer tagId;
}
