package neo.setup.learn_center.criteria.auth.teacher_skills;

import lombok.Getter;
import lombok.Setter;
import neo.setup.learn_center.criteria.GenericCriteria;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Sort;

@Getter
@Setter
@ParameterObject
public class TeacherSkillsCriteria extends GenericCriteria {
    public TeacherSkillsCriteria(Integer size, Integer page, Sort.Direction sort) {
        super(size, page, sort);
    }
}
