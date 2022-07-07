package neo.setup.learn_center.dto.course.course_video_task;

import lombok.*;
import neo.setup.learn_center.dto.GenericDTO;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CourseVideoTaskDetailDTO extends GenericDTO {
    private Integer videoId;

    private String task;

    private Boolean isPublished;
}
