package neo.setup.learn_center.repository.system.transaction_status;

import neo.setup.learn_center.entity.system.transaction_status.TransactionStatus;
import neo.setup.learn_center.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TransactionStatusRepository extends JpaRepository<TransactionStatus, Integer>, BaseRepository {
    @Transactional
    void deleteByCode(UUID code);

    Optional<TransactionStatus> getByCode(UUID code);
}
