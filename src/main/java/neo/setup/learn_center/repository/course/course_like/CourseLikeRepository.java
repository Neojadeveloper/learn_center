package neo.setup.learn_center.repository.course.course_like;

import neo.setup.learn_center.entity.course.course_like.CourseLike;
import neo.setup.learn_center.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository
public interface CourseLikeRepository extends JpaRepository<CourseLike, Integer>, BaseRepository {
    @Transactional
    @Modifying
    @Query(value = "delete from CourseLike where isDeleted = false and code = :code")
    void deleteByCode(UUID code);

    @Query(value = "from CourseLike where isDeleted = false and code = :code")
    CourseLike findByCode(UUID code);
}
