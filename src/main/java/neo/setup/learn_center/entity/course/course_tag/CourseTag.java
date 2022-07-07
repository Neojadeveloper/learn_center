package neo.setup.learn_center.entity.course.course_tag;

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
@Table(name = "course_tag", schema = "course")
public class CourseTag extends Auditable {
    @Column(name = "course_id", nullable = false, updatable = false)
    private Integer courseId;

    @Column(name = "tag_id", nullable = false, updatable = false)
    private Integer tagId;
}
