package neo.setup.learn_center.dto.auth.teacher_skills;

import lombok.*;
import neo.setup.learn_center.dto.GenericDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TeacherSkillsGetDTO extends GenericDTO {
    private Integer teacherId;
    private Integer skillId;
}
