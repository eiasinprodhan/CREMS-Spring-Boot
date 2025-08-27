package com.eiasinprodhan.crems.service;

import com.eiasinprodhan.crems.entity.Transaction;
import com.eiasinprodhan.crems.repository.ITransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private ITransactionRepository transactionRepository;

    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    public Transaction findAllById(int id) {
        return  transactionRepository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        transactionRepository.deleteById(id);
    }
}
