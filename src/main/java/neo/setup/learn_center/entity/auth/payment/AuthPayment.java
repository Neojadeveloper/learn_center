package neo.setup.learn_center.entity.auth.payment;

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
@Table(name = "auth_payment", schema = "auth")
public class AuthPayment extends Auditable {
    @Column(name = "user_id", nullable = false, updatable = false)
    private Integer userId;

    @Column(name = "course_id", nullable = false, updatable = false)
    private Integer courseId;

    @Column(name = "card_id", nullable = false, updatable = false)
    private Integer cardId;

    @Column(name = "amount", nullable = false, updatable = false, length = 30)
    private String amount;
}
