package neo.setup.learn_center.repository.auth.card_type;

import neo.setup.learn_center.entity.auth.card_type.AuthCardType;
import neo.setup.learn_center.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CardTypeRepository extends JpaRepository<AuthCardType, Integer>, BaseRepository {
    @Transactional
    void deleteByCode(UUID code);

    Optional<AuthCardType> getByCode(UUID code);
}
