package neo.setup.learn_center.dto.auth.status;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import neo.setup.learn_center.dto.BaseDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class StatusCreateDTO implements BaseDTO {
    @Size(min = 2, max = 30, message = "{auth.status.name.length}")
    @NotBlank(message = "{auth.status.name.required}")
    private String name;
    @SerializedName(value = "is_published")
    private boolean isPublished;
}
