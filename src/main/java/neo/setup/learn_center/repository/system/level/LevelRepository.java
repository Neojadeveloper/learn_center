package neo.setup.learn_center.repository.system.level;

import neo.setup.learn_center.entity.system.level.Level;
import neo.setup.learn_center.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface LevelRepository extends JpaRepository<Level, Integer>, BaseRepository {

    @Transactional
    void deleteByCode(UUID code);

    Optional<Level> getByCode(UUID code);
}
