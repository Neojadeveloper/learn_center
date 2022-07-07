package neo.setup.learn_center.dto.course.course_level;

import lombok.*;
import neo.setup.learn_center.dto.GenericDTO;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CourseLevelGetDTO extends GenericDTO {
    private Integer courseId;

    private Integer levelId;
}
