package neo.setup.learn_center.enums.auth.block_reason;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BlockReasonFieldsEnum {
    NAME("name");
    private final String value;
}
