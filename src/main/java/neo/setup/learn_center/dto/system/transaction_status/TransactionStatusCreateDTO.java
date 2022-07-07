package neo.setup.learn_center.dto.system.transaction_status;

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
public class TransactionStatusCreateDTO implements BaseDTO {
    @Size(min = 3, max = 120, message = "{system.transaction_status.name.length}")
    @NotBlank(message = "{system.transaction_status.name.required}")
    private String name;
    @SerializedName(value = "is_published")
    private boolean isPublished;
}
