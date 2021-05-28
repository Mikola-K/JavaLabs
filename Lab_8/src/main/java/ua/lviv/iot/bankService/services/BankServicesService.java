package ua.lviv.iot.bankService.services;

import org.springframework.stereotype.Service;
import ua.lviv.iot.bankService.models.BankService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class BankServicesService {
    private AtomicInteger id = new AtomicInteger(0);
    private Map<Integer, BankService> bankServiceMap = new HashMap<Integer, BankService>();

    public List<BankService> getBankServices() {
        return bankServiceMap.values().stream().collect(Collectors.toList());
    }

    public BankService getBankServiceById(final Integer id) {
        return bankServiceMap.get(id);
    }

    public BankService createBankService(final BankService bankService) {
        bankService.setId(id.incrementAndGet());
        bankServiceMap.put(bankService.getId(), bankService);
        return bankService;
    }

    public BankService updateBankServiceById(final Integer id, final BankService bankService) {
        bankService.setId(id);
        return bankServiceMap.put(id, bankService);
    }

    public BankService deleteBankServiceById(final Integer id) {
        return bankServiceMap.remove(id);
    }
}
