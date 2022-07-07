package neo.setup.learn_center.repository.course.course_video;

import neo.setup.learn_center.entity.course.course_video.CourseVideo;
import neo.setup.learn_center.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository
public interface CourseVideoRepository extends JpaRepository<CourseVideo, Integer>, BaseRepository {
    @Transactional
    @Modifying
    @Query(value = "delete from CourseVideo where isDeleted = false and code = :code")
    void deleteByCode(UUID code);

    @Query(value = "from CourseVideo where isDeleted = false and code = :code")
    CourseVideo findByCode(UUID code);
}
