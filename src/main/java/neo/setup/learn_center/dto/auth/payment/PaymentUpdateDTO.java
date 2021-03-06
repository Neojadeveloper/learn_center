package neo.setup.learn_center.dto.auth.payment;

import lombok.*;
import neo.setup.learn_center.dto.GenericDTO;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaymentUpdateDTO extends GenericDTO {
    @Min(value = 1, message = "{payment.min.size}")
    @NotBlank(message = "{auth.payment.userId.required}")
    private Integer userId;
    @Min(value = 1, message = "{payment.min.size}")
    @NotBlank(message = "{auth.payment.courseId.required}")
    private Integer courseId;
    @Min(value = 1, message = "{payment.min.size}")
    @NotBlank(message = "{auth.payment.cardId.required}")
    private Integer cardId;
    @Min(value = 1, message = "{payment.min.size}")
    @NotBlank(message = "{auth.payment.amount.required}")
    private String amount;
}
