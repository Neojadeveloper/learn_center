package neo.setup.learn_center.repository.blog.blog_tag;

import neo.setup.learn_center.entity.blog.blog_tag.BlogTag;
import neo.setup.learn_center.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BlogTagRepository extends JpaRepository<BlogTag, Integer>, BaseRepository {
    @Transactional
    void deleteByCode(UUID code);

    Optional<BlogTag> getByCode(UUID code);
}
