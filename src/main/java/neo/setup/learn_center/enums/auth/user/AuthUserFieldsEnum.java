package neo.setup.learn_center.enums.auth.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AuthUserFieldsEnum {
    USERNAME("username"),
    EMAIL("email"),
    LANGUAGE("language");
    private final String value;
}
