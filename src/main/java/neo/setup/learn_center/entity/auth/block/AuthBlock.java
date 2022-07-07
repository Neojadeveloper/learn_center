package neo.setup.learn_center.entity.auth.block;

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
@Table(name = "auth_block", schema = "auth")
public class AuthBlock extends Auditable {
    @Column(name = "user_id", nullable = false, updatable = false)
    private Integer userId;

    @Column(name = "duration", nullable = false)
    private String duration;

    @Column(name = "blocked_reason", nullable = false, length = 120)
    private String blockedReason;
}
