package neo.setup.learn_center.dto.auth.status;

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
public class StatusUpdateDTO extends GenericDTO {
    @Size(min = 2, max = 30, message = "{auth.language.name.length}")
    @NotBlank(message = "{auth.status.name.required}")
    private String name;
    @SerializedName(value = "is_published")
    @NotBlank(message = "{auth.status.is_published.required}")
    private Boolean isPublished;
}
