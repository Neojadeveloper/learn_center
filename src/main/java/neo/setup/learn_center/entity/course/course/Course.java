package neo.setup.learn_center.entity.course.course;

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
@Table(name = "course", schema = "course")
public class Course extends Auditable {
    @Column(name = "title", nullable = false, length = 120)
    private String title;

    @Column(name = "description", nullable = false, length = 300)
    private String description;

    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(name = "image", nullable = false, columnDefinition = "TEXT")
    private String image;

    @Column(name = "category_id", nullable = false)
    private Integer categoryId;

    @Column(name = "is_published")
    private boolean isPublished;
}
