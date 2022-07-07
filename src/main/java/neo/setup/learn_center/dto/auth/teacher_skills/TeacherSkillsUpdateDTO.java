package neo.setup.learn_center.dto.auth.teacher_skills;

import lombok.*;
import neo.setup.learn_center.dto.GenericDTO;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TeacherSkillsUpdateDTO extends GenericDTO {
    @Min(value = 1, message = "{auth.teacher_skills.teacherId.min.size}")
    @NotBlank(message = "{auth.teacher_skills.teacherId.required}")
    private Integer teacherId;
    @Min(value = 1, message = "{auth.teacher_skills.skillId.min.size}")
    @NotBlank(message = "{auth.teacher_skills.skillId.required}")
    private Integer skillId;
}
