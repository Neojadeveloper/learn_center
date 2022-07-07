package neo.setup.learn_center.dto.course.course_video;

import lombok.*;
import neo.setup.learn_center.dto.GenericDTO;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CourseVideoDetailDTO extends GenericDTO {
    private Integer courseId;

    private String video;

    private LocalDateTime time;

    private Boolean isPublished;
}
