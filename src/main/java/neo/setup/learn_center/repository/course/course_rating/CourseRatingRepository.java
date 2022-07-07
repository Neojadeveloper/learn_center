package neo.setup.learn_center.repository.course.course_rating;

import neo.setup.learn_center.entity.course.course_rating.CourseRating;
import neo.setup.learn_center.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository
public interface CourseRatingRepository extends JpaRepository<CourseRating, Integer>, BaseRepository {
    @Transactional
    @Modifying
    @Query(value = "delete from CourseRating where isDeleted = false and code = :code")
    void deleteByCode(UUID code);

    @Query(value = "from CourseRating where isDeleted = false and code = :code")
    CourseRating findByCode(UUID code);
}
