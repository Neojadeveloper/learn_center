package neo.setup.learn_center.mapper.auth.teacher;

import neo.setup.learn_center.dto.auth.teacher.TeacherCreateDTO;
import neo.setup.learn_center.dto.auth.teacher.TeacherDetailDTO;
import neo.setup.learn_center.dto.auth.teacher.TeacherGetDTO;
import neo.setup.learn_center.dto.auth.teacher.TeacherUpdateDTO;
import neo.setup.learn_center.entity.auth.teacher.Teacher;
import neo.setup.learn_center.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface TeacherMapper extends GenericMapper<TeacherCreateDTO, TeacherUpdateDTO, TeacherGetDTO, TeacherDetailDTO, Teacher> {
}
