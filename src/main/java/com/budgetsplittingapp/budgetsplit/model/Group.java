package com.budgetsplittingapp.budgetsplit.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "groups")
public class Group {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany
    private List<User> members;

    
}
