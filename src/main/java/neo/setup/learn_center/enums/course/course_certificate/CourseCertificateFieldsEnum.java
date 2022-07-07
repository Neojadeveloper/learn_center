package neo.setup.learn_center.enums.course.course_certificate;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CourseCertificateFieldsEnum {
    NAME("name"),
    DESCRIPTION("description"),
    IMAGE("image");

    private final String value;
}
