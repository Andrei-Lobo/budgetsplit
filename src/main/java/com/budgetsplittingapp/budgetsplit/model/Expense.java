package com.budgetsplittingapp.budgetsplit.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "expenses")
public class Expense {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private double amount;
    private String description;

    @ManyToOne
    private User paidBy;

    @ManyToOne
    private Group groupRef;



   

}
