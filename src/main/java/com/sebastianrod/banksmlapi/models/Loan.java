package com.sebastianrod.banksmlapi.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@Entity(name = "loans")
@Table(name = "loans")
@NoArgsConstructor
@AllArgsConstructor
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double mount;

    private Integer dues;

    private Double interest;

    private Date date;

    private Boolean state;

    // TODO LoanState, Agent and Client;
    @ManyToOne()
    @JoinColumn(name = "id_loan_state")
    private LoanState loanState;

    @ManyToOne()
    @JoinColumn(name = "id_agent")
    private Agent agent;

    @ManyToOne()
    @JoinColumn(name = "id_client")
    private Client client;


}
