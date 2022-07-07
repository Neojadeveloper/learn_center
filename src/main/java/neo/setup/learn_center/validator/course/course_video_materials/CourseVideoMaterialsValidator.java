package neo.setup.learn_center.validator.course.course_video_materials;

import neo.setup.learn_center.dto.course.course_video_materials.CourseVideoMaterialsCreateDTO;
import neo.setup.learn_center.dto.course.course_video_materials.CourseVideoMaterialsUpdateDTO;
import neo.setup.learn_center.exception.exception.InvalidValidationException;
import neo.setup.learn_center.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class CourseVideoMaterialsValidator extends AbstractValidator<CourseVideoMaterialsCreateDTO, CourseVideoMaterialsUpdateDTO, UUID> {
    @Override
    public void validOnCreate(CourseVideoMaterialsCreateDTO courseVideoMaterialsCreateDTO) throws InvalidValidationException {
        if (Objects.isNull(courseVideoMaterialsCreateDTO)) {
            throw new InvalidValidationException("DTO is null");
        }
    }

    @Override
    public void validOnUpdate(CourseVideoMaterialsUpdateDTO courseVideoMaterialsUpdateDTO) throws InvalidValidationException {
        if (Objects.isNull(courseVideoMaterialsUpdateDTO)) {
            throw new InvalidValidationException("DTO is null");
        }
    }

    @Override
    public void validateKey(UUID id) throws InvalidValidationException {
        if (Objects.isNull(id)) {
            throw new InvalidValidationException("ID is null");
        }
    }
}
