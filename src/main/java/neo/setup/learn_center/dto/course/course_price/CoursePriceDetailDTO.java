package neo.setup.learn_center.dto.course.course_price;

import lombok.*;
import neo.setup.learn_center.dto.GenericDTO;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CoursePriceDetailDTO extends GenericDTO {
    private Integer courseId;

    private String price;

    private Integer discount;
}
