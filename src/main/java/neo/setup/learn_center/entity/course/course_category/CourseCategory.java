package neo.setup.learn_center.entity.course.course_category;

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
@Table(name = "course_category", schema = "course")
public class CourseCategory extends Auditable {
    @Column(name = "title", nullable = false, length = 120)
    private String title;

    @Column(name = "description", nullable = false, length = 300)
    private String description;

    @Column(name = "is_published")
    private boolean isPublished;
}
