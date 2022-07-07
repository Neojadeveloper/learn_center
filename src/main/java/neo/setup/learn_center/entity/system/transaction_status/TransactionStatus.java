package neo.setup.learn_center.entity.system.transaction_status;

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
@Table(name = "transaction_status", schema = "system")
public class TransactionStatus extends Auditable {
    @Column(name = "name", nullable = false, length = 120)
    private String name;

    @Column(name = "is_published")
    private boolean isPublished;
}
