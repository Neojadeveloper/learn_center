package neo.setup.learn_center.service.blog.blog_tag;

import neo.setup.learn_center.criteria.blog.blog_tag.BlogTagCriteria;
import neo.setup.learn_center.dto.blog.blog_tag.BlogTagCreateDTO;
import neo.setup.learn_center.dto.blog.blog_tag.BlogTagDetailDTO;
import neo.setup.learn_center.dto.blog.blog_tag.BlogTagGetDTO;
import neo.setup.learn_center.dto.blog.blog_tag.BlogTagUpdateDTO;
import neo.setup.learn_center.service.GenericCUDService;
import neo.setup.learn_center.service.GenericGLDService;

import java.util.UUID;

public interface BlogTagService extends GenericCUDService<BlogTagCreateDTO, BlogTagUpdateDTO, UUID>, GenericGLDService<BlogTagGetDTO, BlogTagDetailDTO, BlogTagCriteria, UUID> {
}
