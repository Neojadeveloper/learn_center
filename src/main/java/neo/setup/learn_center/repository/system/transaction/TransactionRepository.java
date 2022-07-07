package neo.setup.learn_center.repository.system.transaction;

import neo.setup.learn_center.entity.system.transaction.Transaction;
import neo.setup.learn_center.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>, BaseRepository {
    @Transactional
    void deleteByCode(UUID code);

    Optional<Transaction> getByCode(UUID code);
}
