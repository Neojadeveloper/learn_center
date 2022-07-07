package neo.setup.learn_center.enums.blog.blog_category;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BlogCategoryFieldsEnum {
    TITLE("title"),
    DESCRIPTION("description");

    private final String value;
}
