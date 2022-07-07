package neo.setup.learn_center.repository.course.course_category;

import neo.setup.learn_center.entity.course.course_category.CourseCategory;
import neo.setup.learn_center.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository
public interface CourseCategoryRepository extends JpaRepository<CourseCategory, Integer>, BaseRepository {
    @Transactional
    @Modifying
    @Query(value = "delete from CourseCategory where isDeleted = false and code = :code")
    void deleteByCode(UUID code);

    @Query(value = "from CourseCategory where isDeleted = false and code = :code")
    CourseCategory findByCode(UUID code);
}
