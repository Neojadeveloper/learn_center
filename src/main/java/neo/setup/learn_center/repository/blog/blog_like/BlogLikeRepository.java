package neo.setup.learn_center.repository.blog.blog_like;

import neo.setup.learn_center.entity.blog.blog_like.BlogLike;
import neo.setup.learn_center.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BlogLikeRepository extends JpaRepository<BlogLike, Integer>, BaseRepository {
    @Transactional
    void deleteByCode(UUID code);

    Optional<BlogLike> getByCode(UUID code);
}
