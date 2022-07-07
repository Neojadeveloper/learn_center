package neo.setup.learn_center.repository.auth.user_role;

import neo.setup.learn_center.entity.auth.user_role.AuthUserRole;
import neo.setup.learn_center.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRoleRepository extends JpaRepository<AuthUserRole, Integer>, BaseRepository {
    @Transactional
    void deleteByCode(UUID code);

    Optional<AuthUserRole> getByCode(UUID code);
}
