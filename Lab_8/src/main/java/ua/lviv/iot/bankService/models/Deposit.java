package ua.lviv.iot.bankService.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@FieldDefaults(makeFinal = false, level = AccessLevel.PROTECTED)

public final class Deposit extends BankService {

    @NonNull Integer depositTerm;
    @NonNull DepositType depositType;

    public Deposit(final String bankName, final BankType bankType, final boolean isAvailable, final float interestRate, final int depositTerm,
                   final DepositType depositType) {
        super (bankName, bankType, isAvailable, interestRate);
        this.depositTerm = depositTerm;
        this.depositType = depositType;
    }
}
