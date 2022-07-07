package neo.setup.learn_center.mapper.system.level;

import neo.setup.learn_center.dto.system.level.LevelCreateDTO;
import neo.setup.learn_center.dto.system.level.LevelDetailDTO;
import neo.setup.learn_center.dto.system.level.LevelGetDTO;
import neo.setup.learn_center.dto.system.level.LevelUpdateDTO;
import neo.setup.learn_center.entity.system.level.Level;
import neo.setup.learn_center.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface LevelMapper extends GenericMapper<LevelCreateDTO, LevelUpdateDTO, LevelGetDTO, LevelDetailDTO, Level> {
}
