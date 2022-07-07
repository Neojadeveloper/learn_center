package neo.setup.learn_center.repository.auth.role;

import neo.setup.learn_center.entity.auth.role.Role;
import neo.setup.learn_center.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>, BaseRepository {
    void deleteByCode(UUID code);

    Optional<Role> getByCode(UUID code);
}
