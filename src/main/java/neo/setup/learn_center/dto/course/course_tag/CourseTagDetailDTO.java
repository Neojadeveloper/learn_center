package neo.setup.learn_center.dto.course.course_tag;

import lombok.*;
import neo.setup.learn_center.dto.GenericDTO;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CourseTagDetailDTO extends GenericDTO {
    private Integer courseId;

    private Integer tagId;
}
