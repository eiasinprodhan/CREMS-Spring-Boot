package com.eiasinprodhan.crems.restcontroller;

import com.eiasinprodhan.crems.entity.Transaction;
import com.eiasinprodhan.crems.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@CrossOrigin("*")
public class TransactionRestController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/")
    public List<Transaction> getTransactions() {
        return  transactionService.findAll();
    }

    @GetMapping("/{id}")
    public Transaction getTransactionById(@PathVariable int id) {
        return transactionService.findAllById(id);
    }

    @PostMapping("/")
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionService.save(transaction);
    }

    @PutMapping("/")
    public Transaction updateTransaction(@RequestBody Transaction transaction) {
        return transactionService.save(transaction);
    }

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable int id) {
         transactionService.deleteById(id);
    }
}
