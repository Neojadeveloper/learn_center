package neo.setup.learn_center.repository.system.tag;

import neo.setup.learn_center.entity.system.tag.Tag;
import neo.setup.learn_center.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer>, BaseRepository {
    @Transactional
    void deleteByCode(UUID code);

    Optional<Tag> getByCode(UUID code);
}
