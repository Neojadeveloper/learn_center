package neo.setup.learn_center.controller.system.tag;

import neo.setup.learn_center.controller.GenericCUDController;
import neo.setup.learn_center.controller.GenericGLDController;
import neo.setup.learn_center.criteria.system.tag.TagCriteria;
import neo.setup.learn_center.dto.system.tag.TagCreateDTO;
import neo.setup.learn_center.dto.system.tag.TagDetailDTO;
import neo.setup.learn_center.dto.system.tag.TagGetDTO;
import neo.setup.learn_center.dto.system.tag.TagUpdateDTO;

import java.util.UUID;

public interface TagController extends GenericCUDController<TagCreateDTO, TagUpdateDTO, UUID>, GenericGLDController<TagGetDTO, TagDetailDTO, TagCriteria, UUID> {
}
