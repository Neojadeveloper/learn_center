package neo.setup.learn_center.dto.auth.token;

import lombok.*;
import neo.setup.learn_center.dto.GenericDTO;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AuthTokenUpdateDTO extends GenericDTO {
    @NotBlank(message = "{user.code.required}")
    private UUID userCode;

    @Min(value = 5, message = "{token.min.size}")
    @NotBlank(message = "{token.required}")
    private String token;

    @NotBlank(message = "{duration.required}")
    private Date duration;

    @Min(value = 5, message = "{type.min.size}")
    @NotBlank(message = "{type.required}")
    private String type;
}
