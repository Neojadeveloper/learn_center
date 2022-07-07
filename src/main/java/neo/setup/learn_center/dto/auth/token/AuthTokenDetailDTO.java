package neo.setup.learn_center.dto.auth.token;

import lombok.*;
import neo.setup.learn_center.dto.GenericDTO;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AuthTokenDetailDTO extends GenericDTO {
    private UUID userCode;
    private String token;
    private Date duration;
    private String type;
}
