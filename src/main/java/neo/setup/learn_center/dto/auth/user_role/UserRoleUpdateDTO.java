package neo.setup.learn_center.dto.auth.user_role;

import lombok.*;
import neo.setup.learn_center.dto.GenericDTO;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRoleUpdateDTO extends GenericDTO {
    @Min(value = 1, message = "{auth.user_role.roleId.min.size}")
    @NotNull(message = "{auth.user_role.roleId.required}")
    private Integer roleId;
    @Min(value = 1, message = "{auth.user_role.userId.min.size}")
    @NotNull(message = "{auth.user_role.userId.required}")
    private Integer userId;
}
