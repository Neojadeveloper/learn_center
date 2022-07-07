package neo.setup.learn_center.dto.auth.user_role;

import lombok.*;
import neo.setup.learn_center.dto.GenericDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRoleGetDTO extends GenericDTO {
    private Integer roleId;
    private Integer userId;
}
