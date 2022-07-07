package neo.setup.learn_center.dto.system.transaction;

import lombok.*;
import neo.setup.learn_center.dto.BaseDTO;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TransactionCreateDTO implements BaseDTO {
    @NotNull(message = "{system.transaction.courseId.required}")
    private Integer courseId;
    @NotNull(message = "{system.transaction.userId.required}")
    private Integer userId;
    @NotNull(message = "{system.transaction.cardId.required}")
    private Integer cardId;
    @Size(min = 4, max = 30, message = "{system.transaction.quantity.length}")
    @NotBlank(message = "{system.transaction.quantity.required}")
    private String quantity;
    @Size(min = 3, max = 120, message = "{system.transaction.status.length}")
    @NotBlank(message = "{system.transaction.status.required}")
    private String status;
}
