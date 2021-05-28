package ua.lviv.iot.bankService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.bankService.models.BankService;
import ua.lviv.iot.bankService.services.BankServicesService;

import java.util.List;


@RestController
@RequestMapping(path = "/bank")
public class BankServiceController {

    @Autowired
    private BankServicesService bankServicesService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<BankService> getBankServiceById(@PathVariable Integer id) {
        BankService existingBankService = bankServicesService.getBankServiceById(id);
        if (existingBankService != null) {
            return ResponseEntity.ok(existingBankService);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<BankService>> getBankService() {
        return ResponseEntity.ok(bankServicesService.getBankServices());
    }

    @PostMapping
    public BankService createBankService(@RequestBody BankService bankService) {
        return bankServicesService.createBankService(bankService);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<BankService> updateSawById (@PathVariable Integer id, @RequestBody BankService bankService) {
        BankService existingBankService = bankServicesService.getBankServiceById(id);
        if (existingBankService != null) {
            ResponseEntity.ok(bankServicesService.updateBankServiceById(id, bankService));
            return ResponseEntity.ok(bankService);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin
    @DeleteMapping(path = "{id}")
    public ResponseEntity<BankService> deleteBankServiceById (@PathVariable Integer id) {
        BankService existingBankService = bankServicesService.getBankServiceById(id);
        if (existingBankService != null) {
            return ResponseEntity.ok(bankServicesService.deleteBankServiceById(id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
