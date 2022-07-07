package neo.setup.learn_center.dto.course.course_video_materials;

import lombok.*;
import neo.setup.learn_center.dto.GenericDTO;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CourseVideoMaterialsDetailDTO extends GenericDTO {
    private Integer videoId;

    private String file;
}
