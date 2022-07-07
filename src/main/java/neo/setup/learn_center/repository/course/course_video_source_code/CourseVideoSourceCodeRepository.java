package neo.setup.learn_center.repository.course.course_video_source_code;

import neo.setup.learn_center.entity.course.course_video_source_code.CourseVideoSourceCode;
import neo.setup.learn_center.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository
public interface CourseVideoSourceCodeRepository extends JpaRepository<CourseVideoSourceCode, Integer>, BaseRepository {
    @Transactional
    @Modifying
    @Query(value = "delete from CourseVideoSourceCode where isDeleted = false and code = :code")
    void deleteByCode(UUID code);

    @Query(value = "from CourseVideoSourceCode where isDeleted = false and code = :code")
    CourseVideoSourceCode findByCode(UUID code);
}