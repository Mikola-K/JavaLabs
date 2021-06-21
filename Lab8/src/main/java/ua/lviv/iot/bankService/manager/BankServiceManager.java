package ua.lviv.iot.bankService.manager;

import lombok.*;
import ua.lviv.iot.bankService.models.BankService;
import ua.lviv.iot.bankService.models.Credit;
import ua.lviv.iot.bankService.models.Deposit;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Data
@FieldDefaults(makeFinal = false, level = AccessLevel.PROTECTED)

public final class BankServiceManager {
    private List<BankService> bankServices;
    private List<Credit> credits;
    private List<Deposit> deposits;

    public BankServiceManager(List<BankService> bankServices, String name) {
        this.bankServices = bankServices;
    }

    public BankServiceManager(List<Credit> creditList) {
        this.credits = creditList;
    }

    public BankServiceManager(List<Deposit> depositList, int num) {
        this.deposits = depositList;
    }

    public List<BankService> getAllBankService() {
        return this.bankServices;
    }

    public List<Credit> getAllCredits() {
        return this.credits;
    }

    public List<Deposit> getAllDeposits() {
        return this.deposits;
    }

    public List<BankService> searchByAvailability(boolean isAvailable) {
        return this.bankServices.stream().filter(is -> is.getIsAvailable().equals(isAvailable)).collect(Collectors.toList());
    }

    public List<BankService> sortByInterestRate(final SortOrder sortOrder) {
        if (sortOrder == SortOrder.ASC) {
            bankServices.sort(Comparator.comparing(BankService::getInterestRate));
        } else {
            bankServices.sort(Comparator.comparing(BankService::getInterestRate).reversed());
        }
        return bankServices;
    }

    public List<Deposit> sortDepositsByTerm(final SortOrder sortOrder) {
        if (sortOrder == SortOrder.ASC) {
            deposits.sort(Comparator.comparing(Deposit::getDepositTerm));
        } else {
            deposits.sort(Comparator.comparing(Deposit::getDepositTerm).reversed());
        }
        return deposits;
    }

    public List<Credit> sortCreditByCreditInterest(final SortOrder sortOrder) {

        if (sortOrder == SortOrder.ASC) {
            credits.sort(Comparator.comparing(Credit::getCreditInterest));
        } else {
            credits.sort(Comparator.comparing(Credit::getCreditInterest).reversed());
        }
        return credits;
    }
}


