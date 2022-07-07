package neo.setup.learn_center.repository.auth.status;

import neo.setup.learn_center.entity.auth.status.Status;
import neo.setup.learn_center.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer>, BaseRepository {
    @Transactional
    void deleteByCode(UUID key);

    Optional<Status> getByCode(UUID code);
}
