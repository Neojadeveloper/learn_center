package neo.setup.learn_center.service.system.tag;

import neo.setup.learn_center.criteria.system.tag.TagCriteria;
import neo.setup.learn_center.dto.system.tag.TagCreateDTO;
import neo.setup.learn_center.dto.system.tag.TagDetailDTO;
import neo.setup.learn_center.dto.system.tag.TagGetDTO;
import neo.setup.learn_center.dto.system.tag.TagUpdateDTO;
import neo.setup.learn_center.service.GenericCUDService;
import neo.setup.learn_center.service.GenericGLDService;

import java.util.UUID;

public interface TagService extends GenericCUDService<TagCreateDTO, TagUpdateDTO, UUID>, GenericGLDService<TagGetDTO, TagDetailDTO, TagCriteria, UUID> {
}
