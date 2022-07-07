package neo.setup.learn_center.repository.auth.teacher;

import neo.setup.learn_center.entity.auth.teacher.Teacher;
import neo.setup.learn_center.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer>, BaseRepository {

    @Transactional
    void deleteByCode(UUID key);

    Optional<Teacher> getByCode(UUID code);
}
