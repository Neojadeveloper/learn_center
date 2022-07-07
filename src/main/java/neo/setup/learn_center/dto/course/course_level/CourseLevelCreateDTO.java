package neo.setup.learn_center.dto.course.course_level;

import lombok.*;
import neo.setup.learn_center.dto.BaseDTO;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CourseLevelCreateDTO implements BaseDTO {
    @NotNull(message = "{course.course.level.course_id.required}")
    private Integer courseId;

    @NotNull(message = "{course.course.level.level_id.required}")
    private Integer levelId;
}
