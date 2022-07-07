package neo.setup.learn_center.dto.auth.language;

import lombok.*;
import neo.setup.learn_center.dto.GenericDTO;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LanguageGetDTO extends GenericDTO {
    private String name;
    private Boolean isPublished;
}
