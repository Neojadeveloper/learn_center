package neo.setup.learn_center.dto.course.course;

import lombok.*;
import neo.setup.learn_center.dto.GenericDTO;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CourseGetDTO extends GenericDTO {
    private String title;

    private String description;

    private String content;

    private String image;

    private Integer categoryId;

    private Boolean isPublished;
}
