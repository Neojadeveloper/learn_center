package neo.setup.learn_center.mapper.course.course_like;

import neo.setup.learn_center.dto.course.course_like.CourseLikeCreateDTO;
import neo.setup.learn_center.dto.course.course_like.CourseLikeDetailDTO;
import neo.setup.learn_center.dto.course.course_like.CourseLikeGetDTO;
import neo.setup.learn_center.dto.course.course_like.CourseLikeUpdateDTO;
import neo.setup.learn_center.entity.course.course_like.CourseLike;
import neo.setup.learn_center.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CourseLikeMapper extends GenericMapper<CourseLikeCreateDTO, CourseLikeUpdateDTO, CourseLikeGetDTO, CourseLikeDetailDTO, CourseLike> {
}
