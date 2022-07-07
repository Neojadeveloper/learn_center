package neo.setup.learn_center.entity.blog.blog_tag;

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
@Table(name = "blog_tag", schema = "blog")
public class BlogTag extends Auditable {
    @Column(name = "blog_id", nullable = false, updatable = false)
    private Integer blogId;

    @Column(name = "tag_id", nullable = false, updatable = false)
    private Integer tagId;
}
