package com.budgetsplittingapp.budgetsplit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.budgetsplittingapp.budgetsplit.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
