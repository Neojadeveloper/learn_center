package neo.setup.learn_center.dto.system.faq;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import neo.setup.learn_center.dto.GenericDTO;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FaqUpdateDTO extends GenericDTO {
    @NotBlank(message = "{system.faq.question.required}")
    private String question;
    @NotBlank(message = "{system.faq.answer.required}")
    private String answer;
    @SerializedName(value = "is_published")
    private boolean isPublished;
}
