package ua.lviv.iot.bankService;

import ua.lviv.iot.bankService.manager.BankServiceManager;
import ua.lviv.iot.bankService.manager.SortOrder;
import ua.lviv.iot.bankService.models.BankService;
import ua.lviv.iot.bankService.models.Credit;
import ua.lviv.iot.bankService.models.BankType;
import ua.lviv.iot.bankService.models.Deposit;
import ua.lviv.iot.bankService.models.CreditTerm;
import ua.lviv.iot.bankService.models.Lending;
import ua.lviv.iot.bankService.models.CreditType;
import ua.lviv.iot.bankService.models.DepositType;

import java.util.Arrays;
import java.util.List;

public final class App {

    public static void main(String[] args) {
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

        System.out.println("\n\n############# Search unavailable credit and deposit.");
        allBankList.searchByAvailability(false).forEach((System.out::println));

        System.out.println("\n\n############# List of Deposits and Credits.");
        allBankList.getAllBankService().forEach(System.out::println);
        allBankList.sortByInterestRate(SortOrder.DESC);
        System.out.println("\n\n############# Sorted by interest rate.");
        allBankList.getAllBankService().forEach(System.out::println);

        System.out.println("\n\n############# List of Credits.");
        allCreditList.getAllCredits().forEach(System.out::println);
        allCreditList.sortCreditByCreditInterest(SortOrder.ASC);
        System.out.println("\n\n############# Sorted credit by interest.");
        allCreditList.getAllCredits().forEach(System.out::println);

        System.out.println("\n\n############# List of Deposits.");
        allDepositList.getAllDeposits().forEach(System.out::println);
        allDepositList.sortDepositsByTerm(SortOrder.ASC);
        System.out.println("\n\n############# Sorted deposit by term.");
        allDepositList.getAllDeposits().forEach(System.out::println);
    }
}
