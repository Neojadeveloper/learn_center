package neo.setup.learn_center.repository.blog.blog_comment;

import neo.setup.learn_center.entity.blog.blog_comment.BlogComment;
import neo.setup.learn_center.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository
public interface BlogCommentRepository extends JpaRepository<BlogComment, Integer>, BaseRepository {
    @Transactional
    void deleteByCode(UUID code);

    BlogComment getByCode(UUID code);
}
