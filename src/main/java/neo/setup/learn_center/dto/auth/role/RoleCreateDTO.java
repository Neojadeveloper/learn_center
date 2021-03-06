package neo.setup.learn_center.dto.auth.role;

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
public class RoleCreateDTO implements BaseDTO {
    @Size(min = 2, max = 30, message = "{auth.role.name.length}")
    @NotBlank(message = "{auth.role.name.required}")
    private String name;
    @SerializedName(value = "is_published")
    @NotBlank(message = "{auth.role.is_published.required}")
    private Boolean isPublished;
}
