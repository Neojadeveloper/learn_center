package neo.setup.learn_center.entity.course.course_rating;

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
@Table(name = "course_rating", schema = "course")
public class CourseRating extends Auditable {
    @Column(name = "course_id", nullable = false, updatable = false)
    private Integer courseId;

    @Column(name = "views", nullable = false)
    private Integer views;

    @Column(name = "stars", nullable = false)
    private Integer stars;

    @Column(name = "buyers", nullable = false)
    private Integer buyers;
}
