package neo.setup.learn_center.dto.system.skill;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import neo.setup.learn_center.dto.BaseDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SkillCreateDTO implements BaseDTO {
    @Size(min = 2, max = 120, message = "{system.skill.name.length}")
    @NotBlank(message = "{system.skill.name.required}")
    private String name;
    @SerializedName(value = "is_published")
    private boolean isPublished;
}
