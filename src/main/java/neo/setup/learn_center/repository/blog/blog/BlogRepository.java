package neo.setup.learn_center.repository.blog.blog;

import neo.setup.learn_center.entity.blog.blog.Blog;
import neo.setup.learn_center.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer>, BaseRepository {
    @Transactional
    void deleteByCode(UUID code);

    Optional<Blog> getByCode(UUID code);
}
