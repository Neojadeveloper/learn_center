package neo.setup.learn_center.service.blog.blog;

import neo.setup.learn_center.criteria.blog.blog.BlogCriteria;
import neo.setup.learn_center.dto.blog.blog.BlogCreateDTO;
import neo.setup.learn_center.dto.blog.blog.BlogDetailDTO;
import neo.setup.learn_center.dto.blog.blog.BlogGetDTO;
import neo.setup.learn_center.dto.blog.blog.BlogUpdateDTO;
import neo.setup.learn_center.service.GenericCUDService;
import neo.setup.learn_center.service.GenericGLDService;

import java.util.UUID;

public interface BlogService extends GenericCUDService<BlogCreateDTO, BlogUpdateDTO, UUID>, GenericGLDService<BlogGetDTO, BlogDetailDTO, BlogCriteria, UUID> {
}
