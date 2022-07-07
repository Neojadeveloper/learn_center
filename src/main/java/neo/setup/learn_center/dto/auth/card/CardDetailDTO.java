package neo.setup.learn_center.dto.auth.card;

import lombok.*;
import neo.setup.learn_center.dto.GenericDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CardDetailDTO extends GenericDTO {
    private Integer userId;
    private String pan;
    private String type;
    private String holderName;
}
