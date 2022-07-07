package neo.setup.learn_center.entity.auth.teacher_skills;

import lombok.*;
import neo.setup.learn_center.entity.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "teacher_skills", schema = "auth")
public class TeacherSkills extends Auditable {
    @Column(name = "teacher_id", nullable = false)
    private Integer teacherId;

    @Column(name = "skill_id", nullable = false)
    private Integer skillId;
}
