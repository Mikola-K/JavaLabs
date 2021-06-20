package ua.lviv.iot.bankService.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@FieldDefaults(makeFinal = false, level = AccessLevel.PROTECTED)

public class Credit extends BankService{
    @NonNull CreditType creditType;
    @NonNull CreditTerm creditTerm;
    @NonNull Lending lending;
    @NonNull String collateralLoans;
    @NonNull String consumerLoans;
    @NonNull int creditInterest;

    public Credit (final String bankName, final BankType bankType, final boolean isAvailable, final float interestRate,
                   final CreditType creditType, final CreditTerm creditTerm, final Lending lending, final String collateralLoans,
                   final String consumerLoans, final int creditInterest) {
        super(bankName, bankType, isAvailable, interestRate);
        this.creditType = creditType;
        this.creditTerm = creditTerm;
        this.lending = lending;
        this.collateralLoans = collateralLoans;
        this.consumerLoans = consumerLoans;
        this.creditInterest = creditInterest;
    }
}

