package neo.setup.learn_center.dto.system.level;

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
public class LevelUpdateDTO extends GenericDTO {
    @Size(min = 3, max = 120, message = "{system.level.name.length}")
    @NotBlank(message = "{system.level.name.required}")
    private String name;
    @SerializedName(value = "is_published")
    private boolean isPublished;
}
