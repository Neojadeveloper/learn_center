package neo.setup.learn_center.criteria.auth.teacher;

import lombok.Getter;
import lombok.Setter;
import neo.setup.learn_center.criteria.GenericCriteria;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Sort;

@Getter
@Setter
@ParameterObject
public class TeacherCriteria extends GenericCriteria {
    public TeacherCriteria(Integer size, Integer page, Sort.Direction sort) {
        super(size, page, sort);
    }
}
