package neo.setup.learn_center.dto.blog.blog_category;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import neo.setup.learn_center.dto.GenericDTO;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BlogCategoryDetailDTO extends GenericDTO {
    private String title;
    private String description;
    @SerializedName(value = "is_published")
    private Boolean isPublished;
}
