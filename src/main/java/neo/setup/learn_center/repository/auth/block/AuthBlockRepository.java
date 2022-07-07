package neo.setup.learn_center.repository.auth.block;

import neo.setup.learn_center.entity.auth.block.AuthBlock;
import neo.setup.learn_center.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AuthBlockRepository extends JpaRepository<AuthBlock, Integer>, BaseRepository {

    @Transactional
    void deleteByCode(UUID code);

    Optional<AuthBlock> getByCode(UUID code);
}
