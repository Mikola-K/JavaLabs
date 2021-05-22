package ua.lviv.iot.bankService.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@FieldDefaults(makeFinal = false, level = AccessLevel.PROTECTED)

public class BankService {
    @NonNull String bankName;
    @NonNull BankType bankType;
    @NonNull Boolean isAvailable;
    @NonNull float interestRate;
}
