package ua.lviv.iot.bankService.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class BankService {
    @NonNull String bankName;
    @NonNull BankType bankType;
    @NonNull Boolean isAvailable;
    @NonNull float interestRate;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    protected Integer id;

    public BankService(final String bankName,final BankType bankType, final Boolean isAvailable,
                       final float interestRate) {
        this(bankName, bankType, isAvailable, interestRate, null);
    }
}
