package neo.setup.learn_center.repository.auth.payment;

import neo.setup.learn_center.entity.auth.payment.AuthPayment;
import neo.setup.learn_center.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PaymentRepository extends JpaRepository<AuthPayment, Integer>, BaseRepository {
    @Transactional
    void deleteByCode(UUID code);

    Optional<AuthPayment> getByCode(UUID code);
}
