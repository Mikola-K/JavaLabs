package ua.lviv.iot.bankService.manager;

import org.junit.jupiter.api.Test;
import ua.lviv.iot.bankService.models.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class BankServiceManagerTest {

    Credit firstBank = new Credit("Tikva", BankType.COMERCIAL, true, 13.3f, CreditType.BANKING,
            CreditTerm.LONG_TERM, Lending.COMERCIAL, "Mortgage real estate", "Commodity", 22);

    Deposit secondBank = new Deposit("Popular Bank", BankType.COMERCIAL, false, 10.3f, 44, DepositType.SAVINGS);

    Credit thirdBank = new Credit("Money for you", BankType.NATIONAL, true, 33.4f, CreditType.BANKING,
            CreditTerm.LONG_TERM, Lending.COMMODITY, "Tesla shares", "Cash", 10);

    Credit fourthBank = new Credit("Free Money", BankType.COMERCIAL, false, 3.3f, CreditType.PUBLIC,
            CreditTerm.MEDIUM_TERM, Lending.COMMODITY, "Apple shares", "Cash", 100);

    Deposit fifthBank = new Deposit("BankA", BankType.NATIONAL, true, 11.2f, 1, DepositType.SAVINGS);

    Deposit sixthBank = new Deposit("Ukraine", BankType.COMERCIAL, false, 44.8f, 20, DepositType.UNIVERSAL);

    List<BankService> bankServiceList = Arrays.asList(fifthBank, secondBank, thirdBank, fourthBank, fifthBank, sixthBank);
    BankServiceManager allBankList = new BankServiceManager(bankServiceList, "BankServiceManager");

    List<Credit> creditList = Arrays.asList(firstBank, thirdBank, fourthBank);
    BankServiceManager allCreditList = new BankServiceManager(creditList);

    List<Deposit> depositList = Arrays.asList(secondBank, fifthBank, sixthBank);
    BankServiceManager allDepositList = new BankServiceManager(depositList, 3);

    @Test
    public void searchByAvailability() {
        List<BankService> expected = bankServiceList.stream().filter(BankService::getIsAvailable).collect(Collectors.toList());
        assertEquals(expected, allBankList.searchByAvailability(true));
    }

    @Test
    public void sortByInterestRate() {
        bankServiceList.sort(Comparator.comparing(BankService::getInterestRate));
        assertEquals(bankServiceList, allBankList.sortByInterestRate(SortOrder.ASC));
        bankServiceList.sort(Comparator.comparing(BankService::getInterestRate).reversed());
        assertEquals(bankServiceList, allBankList.sortByInterestRate(SortOrder.DESC));
    }

    @Test
    public void sortDepositsByTerm() {
        depositList.sort(Comparator.comparing(Deposit::getDepositTerm));
        assertEquals(depositList, allDepositList.sortDepositsByTerm(SortOrder.ASC));
        depositList.sort(Comparator.comparing(Deposit::getDepositTerm).reversed());
        assertEquals(depositList, allDepositList.sortDepositsByTerm(SortOrder.DESC));
    }

    @Test
    public void sortCreditByCreditInterest() {
        creditList.sort(Comparator.comparing(Credit::getCreditInterest));
        assertEquals(creditList, allCreditList.sortCreditByCreditInterest(SortOrder.ASC));
        creditList.sort(Comparator.comparing(Credit::getCreditInterest).reversed());
        assertEquals(creditList, allCreditList.sortCreditByCreditInterest(SortOrder.DESC));
    }
}
