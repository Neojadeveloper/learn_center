package neo.setup.learn_center.entity.system.skill;

import lombok.*;
import neo.setup.learn_center.entity.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "skill", schema = "system")
public class Skill extends Auditable {
    @Column(name = "name", nullable = false, length = 120)
    private String name;

    @Column(name = "is_published")
    private boolean isPublished;
}
