package neo.setup.learn_center.dto.system.transaction;

import lombok.*;
import neo.setup.learn_center.dto.GenericDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TransactionDetailDTO extends GenericDTO {
    private Integer courseId;
    private Integer userId;
    private Integer cardId;
    private String quantity;
    private String status;
}
