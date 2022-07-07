package neo.setup.learn_center.enums.system.transaction;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TransactionFieldsEnum {
    QUANTITY("quantity"),
    STATUS("status");

    private final String value;
}
