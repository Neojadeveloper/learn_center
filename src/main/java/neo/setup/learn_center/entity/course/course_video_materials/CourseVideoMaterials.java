package neo.setup.learn_center.entity.course.course_video_materials;

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
@Table(name = "course_video_materials", schema = "course")
public class CourseVideoMaterials extends Auditable {
    @Column(name = "video_id", nullable = false, updatable = false)
    private Integer videoId;

    @Column(name = "file", nullable = false, updatable = false, columnDefinition = "TEXT")
    private String file;
}
