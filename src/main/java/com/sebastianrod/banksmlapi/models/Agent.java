package com.sebastianrod.banksmlapi.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity(name = "agents")
@Table(name = "agents")
@NoArgsConstructor
@AllArgsConstructor
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String dni;

    private String names;

    private String lastnames;

    private String address;

    private String email_address;

    private String password;

    private Boolean state;

    // TODO TypeAgent

    @ManyToOne()
    @JoinColumn(name = "id_type_agent")
    private TypeAgent typeAgent;

}