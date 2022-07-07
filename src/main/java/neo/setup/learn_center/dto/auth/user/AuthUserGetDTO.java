package neo.setup.learn_center.dto.auth.user;

import lombok.*;
import neo.setup.learn_center.dto.GenericDTO;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AuthUserGetDTO extends GenericDTO {
    private String username;
    private String password;
    private String email;
    private String image;
    private String language;
    private String status;
}
