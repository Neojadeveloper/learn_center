package neo.setup.learn_center.repository.auth.card;

import neo.setup.learn_center.entity.auth.card.AuthCard;
import neo.setup.learn_center.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CardRepository extends JpaRepository<AuthCard, Integer>, BaseRepository {
    @Transactional
    void deleteByCode(UUID code);

    Optional<AuthCard> getByCode(UUID code);
}
