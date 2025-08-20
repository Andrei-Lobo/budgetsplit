package com.budgetsplittingapp.budgetsplit.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "group_members")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class GroupMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "group_id")
    @JsonIgnoreProperties("members") // Prevent loop
    private Group group;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // getters/setters
}
