package neo.setup.learn_center.repository.course.course;

import neo.setup.learn_center.entity.course.course.Course;
import neo.setup.learn_center.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>, BaseRepository {
    @Transactional
    @Modifying
    @Query(value = "delete from Course where isDeleted = false and code = :code")
    void deleteByCode(UUID code);

    @Query(value = "from Course where isDeleted = false and code = :code")
    Course findByCode(UUID code);
}
