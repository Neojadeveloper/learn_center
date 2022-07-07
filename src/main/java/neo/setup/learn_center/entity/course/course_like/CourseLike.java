package neo.setup.learn_center.entity.course.course_like;

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
@Table(name = "course_like", schema = "course")
public class CourseLike extends Auditable {
    @Column(name = "course_id", nullable = false, updatable = false)
    private Integer courseId;

    @Column(name = "user_id", nullable = false, updatable = false)
    private Integer userId;
}
