package neo.setup.learn_center.dto.auth.payment;

import lombok.*;
import neo.setup.learn_center.dto.GenericDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaymentDetailDTO extends GenericDTO {
    private Integer userId;
    private Integer courseId;
    private Integer cardId;
    private String amount;
}
