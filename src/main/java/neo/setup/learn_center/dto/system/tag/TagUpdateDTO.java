package neo.setup.learn_center.dto.system.tag;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import neo.setup.learn_center.dto.GenericDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TagUpdateDTO extends GenericDTO {
    @Size(min = 2, max = 120, message = "{system.tag.name.length}")
    @NotBlank(message = "{system.tag.name.required}")
    private String name;
    @SerializedName(value = "is_published")
    private boolean isPublished;
}
