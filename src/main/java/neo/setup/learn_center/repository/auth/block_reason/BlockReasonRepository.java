package neo.setup.learn_center.repository.auth.block_reason;

import neo.setup.learn_center.entity.auth.block_reason.AuthBlockReason;
import neo.setup.learn_center.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BlockReasonRepository extends JpaRepository<AuthBlockReason, Integer>, BaseRepository {

    @Transactional
    void deleteByCode(UUID code);

    Optional<AuthBlockReason> getByCode(UUID code);
}
