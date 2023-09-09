package com.sebastianrod.banksmlapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@Entity(name = "dues")
@Table(name = "dues")
@NoArgsConstructor
@AllArgsConstructor
public class Due {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date due_date;

    private Date date_paid;

    private Double monthly_payment;

    private Double interest;

    private Double capital;

    private Double saldo;

    private Double mora;

    private Boolean state;


    // TODO DueState and Loan
    @ManyToOne()
    @JoinColumn(name = "id_due_state")
    private DueState dueState;

    @ManyToOne()
    @JoinColumn(name = "id_loan")
    private Loan loan;

    public void calculateMora(){
        long dueDateTime = this.getDue_date().getTime() ;
        long currentDateTime = new Date().getTime();
        long daysDueDate = (long) Math.floor(dueDateTime / (1000*60*60*24)); // convertimos a dias, para que no afecten cambios de hora
        long daysCurrentDate = (long) Math.floor(currentDateTime / (1000*60*60*24)); // convertimos a dias, para que no afecten cambios de hora
        long daysLate = daysCurrentDate - daysDueDate;

        if (daysLate > 0){
            this.setMora(daysLate * 0.5);
        } else {
            this.setMora(0.0);
        }
    }

}
