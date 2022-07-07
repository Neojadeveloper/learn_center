package neo.setup.learn_center.dto.course.course_rating;

import lombok.*;
import neo.setup.learn_center.dto.BaseDTO;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CourseRatingCreateDTO implements BaseDTO {
    @NotNull(message = "{course.course.rating.course_id.required}")
    private Integer courseId;
}
