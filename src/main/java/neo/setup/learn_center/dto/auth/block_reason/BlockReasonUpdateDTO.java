package neo.setup.learn_center.dto.auth.block_reason;

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
public class BlockReasonUpdateDTO extends GenericDTO {
    @Size(min = 3, max = 120, message = "{auth.block_reason.name.length}")
    @NotBlank(message = "{auth.block_reason.name.required}")
    private String name;
    @SerializedName(value = "is_published")
    private boolean isPublished;
}
