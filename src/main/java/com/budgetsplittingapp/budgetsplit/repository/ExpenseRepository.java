package com.budgetsplittingapp.budgetsplit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.budgetsplittingapp.budgetsplit.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long>{
    
}
