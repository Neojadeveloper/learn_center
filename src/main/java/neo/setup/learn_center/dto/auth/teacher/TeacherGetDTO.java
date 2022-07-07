package neo.setup.learn_center.dto.auth.teacher;

import lombok.*;
import neo.setup.learn_center.dto.GenericDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TeacherGetDTO extends GenericDTO {
    private Integer userId;
    private String experience;
    private Integer age;
    private String about;
}
