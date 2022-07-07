package neo.setup.learn_center.dto.auth.payment;

import lombok.*;
import neo.setup.learn_center.dto.BaseDTO;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaymentCreateDTO implements BaseDTO {
    @Min(value = 1, message = "{payment.min.size}")
    @NotNull(message = "{auth.payment.userId.required}")
    private Integer userId;
    @Min(value = 1, message = "{payment.min.size}")
    @NotNull(message = "{auth.payment.courseId.required}")
    private Integer courseId;
    @Min(value = 1, message = "{payment.min.size}")
    @NotNull(message = "{auth.payment.cardId.required}")
    private Integer cardId;
    @Min(value = 1, message = "{payment.min.size}")
    @NotBlank(message = "{auth.payment.amount.required}")
    private String amount;
}
