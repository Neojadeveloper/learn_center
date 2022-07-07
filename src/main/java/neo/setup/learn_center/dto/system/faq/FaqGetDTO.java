package neo.setup.learn_center.dto.system.faq;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import neo.setup.learn_center.dto.GenericDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FaqGetDTO extends GenericDTO {
    private String question;
    private String answer;
    @SerializedName(value = "is_published")
    private boolean isPublished;
}
