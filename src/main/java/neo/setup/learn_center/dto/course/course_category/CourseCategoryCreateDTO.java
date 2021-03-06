package neo.setup.learn_center.dto.course.course_category;

import lombok.*;
import neo.setup.learn_center.dto.BaseDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CourseCategoryCreateDTO implements BaseDTO {
    @NotBlank(message = "{course.course.category.title.required}")
    @Size(min = 3, max = 120, message = "{course.course.category.title.length}")
    private String title;

    @NotBlank(message = "{course.course.category.description.required}")
    @Size(min = 12, max = 300, message = "{course.course.category.description.length}")
    private String description;

    @NotNull(message = "{course.course.category.isPublished.required}")
    private Boolean isPublished;
}
