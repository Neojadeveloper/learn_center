package neo.setup.learn_center.repository.system.faq;

import neo.setup.learn_center.entity.system.faq.Faq;
import neo.setup.learn_center.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface FaqRepository extends JpaRepository<Faq, Integer>, BaseRepository {

    @Transactional
    void deleteByCode(UUID code);

    Optional<Faq> getByCode(UUID code);
}
