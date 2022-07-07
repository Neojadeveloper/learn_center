package neo.setup.learn_center.dto.course.course_video_materials;

import lombok.*;
import neo.setup.learn_center.dto.GenericDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CourseVideoMaterialsUpdateDTO extends GenericDTO {
    @NotNull(message = "{course.course.video.materials.video_id.required}")
    private Integer videoId;

    @NotBlank(message = "{course.course.video.materials.file.required}")
    private String file;
}
