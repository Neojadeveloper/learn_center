package neo.setup.learn_center.dto.course.course_rating;

import lombok.*;
import neo.setup.learn_center.dto.GenericDTO;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CourseRatingUpdateDTO extends GenericDTO {
    private Integer views;

    private Integer stars;

    private Integer buyers;
}
