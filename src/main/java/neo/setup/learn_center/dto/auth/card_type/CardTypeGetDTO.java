package neo.setup.learn_center.dto.auth.card_type;

import lombok.*;
import neo.setup.learn_center.dto.GenericDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CardTypeGetDTO extends GenericDTO {
    private String name;
    private boolean isPublished;
}
