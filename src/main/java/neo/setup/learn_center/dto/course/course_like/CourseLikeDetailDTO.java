package neo.setup.learn_center.dto.course.course_like;

import lombok.*;
import neo.setup.learn_center.dto.GenericDTO;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CourseLikeDetailDTO extends GenericDTO {
    private Integer courseId;

    private Integer userId;
}
