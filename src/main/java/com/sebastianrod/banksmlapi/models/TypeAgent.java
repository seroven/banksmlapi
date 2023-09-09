package com.sebastianrod.banksmlapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity(name = "type_agent")
@Table(name = "type_agent")
@NoArgsConstructor
@AllArgsConstructor
public class TypeAgent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;

    private Boolean state;


}