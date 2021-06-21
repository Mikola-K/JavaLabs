package ua.lviv.iot.bankService.manager;

import org.junit.jupiter.api.Test;
import ua.lviv.iot.bankService.models.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BankServiceManagerTest {

    Credit creditTikva = new Credit("Tikva", BankType.COMERCIAL, true, 13.3f, CreditType.BANKING,
            CreditTerm.LONG_TERM, Lending.COMERCIAL, "Mortgage real estate", "Commodity", 22);

    Deposit depositPopularBank = new Deposit("Popular Bank", BankType.COMERCIAL, false, 10.3f, 44, DepositType.SAVINGS);

    Credit creditMoneyForYou = new Credit("Money for you", BankType.NATIONAL, true, 33.4f, CreditType.BANKING,
            CreditTerm.LONG_TERM, Lending.COMMODITY, "Tesla shares", "Cash", 10);

    Credit creditFreeMoney = new Credit("Free Money", BankType.COMERCIAL, false, 3.3f, CreditType.PUBLIC,
            CreditTerm.MEDIUM_TERM, Lending.COMMODITY, "Apple shares", "Cash", 100);

    Deposit depositBankA = new Deposit("BankA", BankType.NATIONAL, true, 11.2f, 1, DepositType.SAVINGS);

    Deposit depositUkraine = new Deposit("Ukraine", BankType.COMERCIAL, false, 44.8f, 20, DepositType.UNIVERSAL);

    List<BankService> bankServiceList = Arrays.asList(creditTikva, depositPopularBank, creditMoneyForYou, creditFreeMoney, depositBankA, depositUkraine);
    BankServiceManager bankServiceManager = new BankServiceManager(bankServiceList, "BankServiceManager");

    List<Credit> creditList = Arrays.asList(creditTikva, creditMoneyForYou, creditFreeMoney);
    BankServiceManager creditsManager = new BankServiceManager(creditList);

    List<Deposit> depositList = Arrays.asList(depositPopularBank, depositBankA, depositUkraine);
    BankServiceManager depositsManager = new BankServiceManager(depositList, 3);

    @Test
    public void searchByAvailability() {
        List<BankService> expected = new LinkedList<>();
        expected.add(creditTikva);
        expected.add(creditMoneyForYou);
        expected.add(depositBankA);
        assertEquals(expected, bankServiceManager.searchByAvailability(true));
    }

    @Test
    public void sortByInterestRate() {
        List<BankService> expectedACS = new LinkedList<>();
        expectedACS.add(creditFreeMoney);
        expectedACS.add(depositPopularBank);
        expectedACS.add(depositBankA);
        expectedACS.add(creditTikva);
        expectedACS.add(creditMoneyForYou);
        expectedACS.add(depositUkraine);
        assertEquals(expectedACS, bankServiceManager.sortByInterestRate(SortOrder.ASC));
        List<BankService> expectedDESC = new LinkedList<>();
        expectedDESC.add(depositUkraine);
        expectedDESC.add(creditMoneyForYou);
        expectedDESC.add(creditTikva);
        expectedDESC.add(depositBankA);
        expectedDESC.add(depositPopularBank);
        expectedDESC.add(creditFreeMoney);
        assertEquals(expectedDESC, bankServiceManager.sortByInterestRate(SortOrder.DESC));
    }

    @Test
    public void sortDepositsByTerm() {
        List<Deposit> expectedACS = new LinkedList<>();
        expectedACS.add(depositBankA);
        expectedACS.add(depositUkraine);
        expectedACS.add(depositPopularBank);
        assertEquals(expectedACS, depositsManager.sortDepositsByTerm(SortOrder.ASC));
        List<Deposit> expectedDESC = new LinkedList<>();
        expectedDESC.add(depositPopularBank);
        expectedDESC.add(depositUkraine);
        expectedDESC.add(depositBankA);
        assertEquals(expectedDESC, depositsManager.sortDepositsByTerm(SortOrder.DESC));
    }

    @Test
    public void sortCreditByCreditInterest() {
        List<Credit> expectedACS = new LinkedList<>();
        expectedACS.add(creditMoneyForYou);
        expectedACS.add(creditTikva);
        expectedACS.add(creditFreeMoney);
        assertEquals(expectedACS, creditsManager.sortCreditByCreditInterest(SortOrder.ASC));
        List<Credit> expectedDESC = new LinkedList<>();
        expectedDESC.add(creditFreeMoney);
        expectedDESC.add(creditTikva);
        expectedDESC.add(creditMoneyForYou);
        assertEquals(expectedDESC, creditsManager.sortCreditByCreditInterest(SortOrder.DESC));
    }
}
