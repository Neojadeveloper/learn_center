package neo.setup.learn_center.dto.course.course_category;

import lombok.*;
import neo.setup.learn_center.dto.GenericDTO;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CourseCategoryGetDTO extends GenericDTO {
    private String title;

    private String description;

    private Boolean isPublished;
}
