package neo.setup.learn_center.entity.auth.block_reason;

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
@Table(name = "auth_block_reason", schema = "auth")
public class AuthBlockReason extends Auditable {
    @Column(name = "name", nullable = false, unique = true, length = 120)
    private String name;

    @Column(name = "is_published")
    private boolean isPublished;
}
