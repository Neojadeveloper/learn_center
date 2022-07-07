package neo.setup.learn_center.entity.auth.user_role;

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
@Table(name = "auth_user_role", schema = "auth")
public class AuthUserRole extends Auditable {
    @Column(name = "user_id", nullable = false, updatable = false)
    private Integer userId;

    @Column(name = "role_id", nullable = false, updatable = false)
    private Integer roleId;
}
