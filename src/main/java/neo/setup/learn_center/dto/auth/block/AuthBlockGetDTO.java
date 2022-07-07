package neo.setup.learn_center.dto.auth.block;

import lombok.*;
import neo.setup.learn_center.dto.GenericDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthBlockGetDTO extends GenericDTO {
    private Integer userId;
    private String duration;
    private String blockedReason;
}
