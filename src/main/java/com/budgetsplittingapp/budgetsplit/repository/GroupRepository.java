package com.budgetsplittingapp.budgetsplit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.budgetsplittingapp.budgetsplit.model.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {
    
}
