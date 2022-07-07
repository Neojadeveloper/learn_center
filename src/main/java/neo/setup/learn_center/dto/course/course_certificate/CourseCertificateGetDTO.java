package neo.setup.learn_center.dto.course.course_certificate;

import lombok.*;
import neo.setup.learn_center.dto.GenericDTO;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CourseCertificateGetDTO extends GenericDTO {
    private String name;

    private String description;

    private String image;

    private Integer courseId;

    private Boolean isPublished;
}
