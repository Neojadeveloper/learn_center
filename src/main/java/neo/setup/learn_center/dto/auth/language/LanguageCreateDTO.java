package neo.setup.learn_center.dto.auth.language;

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
public class LanguageCreateDTO implements BaseDTO {
    @NotBlank(message = "{auth.language.name.required}")
    @Size(min = 2, max = 3, message = "{auth.language.name.length}")
    private String name;
    @SerializedName(value = "is_published")
    private boolean isPublished;
}
