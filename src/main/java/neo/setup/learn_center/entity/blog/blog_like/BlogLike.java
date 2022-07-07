package neo.setup.learn_center.entity.blog.blog_like;

import lombok.*;
import neo.setup.learn_center.entity.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "blog_like", schema = "blog")
public class BlogLike extends Auditable {
    @Column(name = "blog_id", nullable = false, updatable = false)
    private Integer blogId;

    @Column(name = "user_id", nullable = false, updatable = false)
    private Integer userId;
}
