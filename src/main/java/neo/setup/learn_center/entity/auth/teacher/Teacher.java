package neo.setup.learn_center.entity.auth.teacher;

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
@Table(name = "teacher", schema = "auth")
public class Teacher extends Auditable {
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "experience", nullable = false, length = 120)
    private String experience;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "about", nullable = false, columnDefinition = "TEXT")
    private String about;
}
