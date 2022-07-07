package neo.setup.learn_center.dto.auth.block_reason;

import lombok.*;
import neo.setup.learn_center.dto.GenericDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BlockReasonGetDTO extends GenericDTO {
    private String name;
    private boolean isPublished;
}
