package neo.setup.learn_center.dto.auth.token;

import lombok.*;
import neo.setup.learn_center.dto.GenericDTO;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AuthTokenGetDTO extends GenericDTO {
    private String type;
    private String token;
}
