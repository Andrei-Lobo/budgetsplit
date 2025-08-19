package com.budgetsplittingapp.budgetsplit.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.budgetsplittingapp.budgetsplit.model.Expense;
import com.budgetsplittingapp.budgetsplit.repository.ExpenseRepository;
import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    private ExpenseRepository expRepo;

    public ExpenseController(ExpenseRepository expRepo) {
        this.expRepo = expRepo;
    }

    @PostMapping
    public Expense createExpense(@RequestBody Expense expense) {
        return expRepo.save(expense);
    }

    @GetMapping
    public List<Expense> getExpense() {
        return expRepo.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable Long id) {
        expRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
