package neo.setup.learn_center.entity.course.course_certificate;

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
@Table(name = "course_certificate", schema = "course")
public class CourseCertificate extends Auditable {
    @Column(name = "name", nullable = false, length = 120)
    private String name;

    @Column(name = "description", nullable = false, length = 300)
    private String description;

    @Column(name = "image", nullable = false, columnDefinition = "TEXT")
    private String image;

    @Column(name = "course_id", nullable = false)
    private Integer courseId;

    @Column(name = "is_published")
    private boolean isPublished;
}
