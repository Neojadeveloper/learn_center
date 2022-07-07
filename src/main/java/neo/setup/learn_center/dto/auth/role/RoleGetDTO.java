package neo.setup.learn_center.dto.auth.role;

import lombok.*;
import neo.setup.learn_center.dto.GenericDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoleGetDTO extends GenericDTO {
    private String name;
    private Boolean isPublished;
}
