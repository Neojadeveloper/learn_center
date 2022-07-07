package neo.setup.learn_center.dto.system.tag;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import neo.setup.learn_center.dto.GenericDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TagDetailDTO extends GenericDTO {
    private String name;
    @SerializedName(value = "is_published")
    private boolean isPublished;
}
