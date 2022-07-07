package neo.setup.learn_center.mapper.system.tag;

import neo.setup.learn_center.dto.system.tag.TagCreateDTO;
import neo.setup.learn_center.dto.system.tag.TagDetailDTO;
import neo.setup.learn_center.dto.system.tag.TagGetDTO;
import neo.setup.learn_center.dto.system.tag.TagUpdateDTO;
import neo.setup.learn_center.entity.system.tag.Tag;
import neo.setup.learn_center.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface TagMapper extends GenericMapper<TagCreateDTO, TagUpdateDTO, TagGetDTO, TagDetailDTO, Tag> {
}
