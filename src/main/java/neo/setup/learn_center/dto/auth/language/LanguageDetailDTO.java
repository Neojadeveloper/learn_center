package neo.setup.learn_center.dto.auth.language;

import lombok.*;
import neo.setup.learn_center.dto.GenericDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LanguageDetailDTO extends GenericDTO {
    private String name;
    private Boolean isPublished;
}
