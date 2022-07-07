package neo.setup.learn_center.repository.course.course_certificate;

import neo.setup.learn_center.entity.course.course_certificate.CourseCertificate;
import neo.setup.learn_center.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository
public interface CourseCertificateRepository extends JpaRepository<CourseCertificate, Integer>, BaseRepository {
    @Transactional
    @Modifying
    @Query(value = "delete from CourseCertificate where isDeleted = false and code = :code")
    void deleteByCode(UUID code);

    @Query(value = "from CourseCertificate where isDeleted = false and code = :code")
    CourseCertificate findByCode(UUID code);
}
