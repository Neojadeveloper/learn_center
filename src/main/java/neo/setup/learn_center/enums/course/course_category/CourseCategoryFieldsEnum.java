package neo.setup.learn_center.enums.course.course_category;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CourseCategoryFieldsEnum {
    TITLE("title"),
    DESCRIPTION("description");

    private final String value;
}
