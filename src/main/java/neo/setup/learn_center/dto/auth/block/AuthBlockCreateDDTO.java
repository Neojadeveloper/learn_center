package neo.setup.learn_center.dto.auth.block;

import lombok.*;
import neo.setup.learn_center.dto.BaseDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthBlockCreateDDTO implements BaseDTO {
    @NotNull(message = "{auth.auth_block.userId.required}")
    private Integer userId;
    @NotNull(message = "{auth.auth_block.duration.required}")
    private String duration;
    @Size(min = 5, max = 120, message = "{auth.auth_block.blockReason.length}")
    @NotBlank(message = "{auth.auth_block.blockedReason.required}")
    private String blockedReason;
}
