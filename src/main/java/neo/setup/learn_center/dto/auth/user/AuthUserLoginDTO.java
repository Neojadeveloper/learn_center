package neo.setup.learn_center.dto.auth.user;

import lombok.*;
import neo.setup.learn_center.dto.BaseDTO;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AuthUserLoginDTO implements BaseDTO {
    @NotBlank(message = "{user.username.required}")
    private String username;
    @NotBlank(message = "{user.password.required}")
    private String password;
}
