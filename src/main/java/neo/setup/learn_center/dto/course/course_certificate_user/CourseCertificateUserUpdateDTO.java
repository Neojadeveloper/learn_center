package neo.setup.learn_center.dto.course.course_certificate_user;

import lombok.*;
import neo.setup.learn_center.dto.GenericDTO;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CourseCertificateUserUpdateDTO extends GenericDTO {
    private Integer userId;

    private Integer certificateId;
}
