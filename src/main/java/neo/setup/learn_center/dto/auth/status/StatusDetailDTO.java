package neo.setup.learn_center.dto.auth.status;

import lombok.*;
import neo.setup.learn_center.dto.GenericDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StatusDetailDTO extends GenericDTO {
    private String name;
    private Boolean isPublished;
}
