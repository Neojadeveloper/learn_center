package neo.setup.learn_center.entity.course.course_video_task;

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
@Table(name = "course_video_task", schema = "course")
public class CourseVideoTask extends Auditable {
    @Column(name = "video_id", nullable = false, updatable = false)
    private Integer videoId;

    @Column(name = "task", nullable = false, columnDefinition = "TEXT")
    private String task;

    @Column(name = "is_published")
    private boolean isPublished;
}
