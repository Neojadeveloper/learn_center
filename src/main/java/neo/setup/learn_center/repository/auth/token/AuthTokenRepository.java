package neo.setup.learn_center.repository.auth.token;

import neo.setup.learn_center.entity.auth.token.AuthToken;
import neo.setup.learn_center.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AuthTokenRepository extends JpaRepository<AuthToken, Integer>, BaseRepository {
    @Transactional
    void deleteByCode(UUID key);

    Optional<AuthToken> getByCode(UUID code);
}
