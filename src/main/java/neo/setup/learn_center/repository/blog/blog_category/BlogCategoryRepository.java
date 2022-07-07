package neo.setup.learn_center.repository.blog.blog_category;

import neo.setup.learn_center.entity.blog.blog_category.BlogCategory;
import neo.setup.learn_center.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BlogCategoryRepository extends JpaRepository<BlogCategory, Integer>, BaseRepository {
    @Transactional
    void deleteByCode(UUID code);

    Optional<BlogCategory> getByCode(UUID code);
}
