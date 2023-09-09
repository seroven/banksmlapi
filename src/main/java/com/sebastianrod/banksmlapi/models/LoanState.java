package com.sebastianrod.banksmlapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity(name = "loan_state")
@Table(name = "loan_state")
@NoArgsConstructor
@AllArgsConstructor
public class LoanState {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;

    private Boolean state;

}