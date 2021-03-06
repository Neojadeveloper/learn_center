package neo.setup.learn_center.entity.course.course_video;

import lombok.*;
import neo.setup.learn_center.entity.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course_video", schema = "course")
public class CourseVideo extends Auditable {
    @Column(name = "course_id", nullable = false)
    private Integer courseId;

    @Column(name = "video", nullable = false, columnDefinition = "TEXT")
    private String video;

    @Column(name = "time", nullable = false)
    private LocalDateTime time;

    @Column(name = "is_published")
    private boolean isPublished;
}
