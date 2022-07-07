package neo.setup.learn_center.enums.system.transaction_status;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TransactionStatusFieldsEnum {
    NAME("name");

    private final String value;
}
