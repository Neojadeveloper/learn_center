package neo.setup.learn_center.repository.blog.blog_rating;

import neo.setup.learn_center.entity.blog.blog_rating.BlogRating;
import neo.setup.learn_center.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BlogRatingRepository extends JpaRepository<BlogRating, Integer>, BaseRepository {
    @Transactional
    void deleteByCode(UUID code);

    Optional<BlogRating> getByCode(UUID code);
}
