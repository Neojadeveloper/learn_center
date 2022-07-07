package neo.setup.learn_center.dto.course.course_video_source_code;

import lombok.*;
import neo.setup.learn_center.dto.BaseDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CourseVideoSourceCodeCreateDTO implements BaseDTO {
    @NotNull(message = "{course.course.video.source.code.video_id.required}")
    private Integer videoId;

    @NotBlank(message = "{course.course.video.source.code.file.required}")
    private String file;
}
