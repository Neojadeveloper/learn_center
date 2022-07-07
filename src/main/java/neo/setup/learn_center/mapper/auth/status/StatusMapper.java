package neo.setup.learn_center.mapper.auth.status;

import neo.setup.learn_center.dto.auth.status.StatusCreateDTO;
import neo.setup.learn_center.dto.auth.status.StatusDetailDTO;
import neo.setup.learn_center.dto.auth.status.StatusGetDTO;
import neo.setup.learn_center.dto.auth.status.StatusUpdateDTO;
import neo.setup.learn_center.entity.auth.status.Status;
import neo.setup.learn_center.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface StatusMapper extends GenericMapper<StatusCreateDTO, StatusUpdateDTO, StatusGetDTO, StatusDetailDTO, Status> {
}
