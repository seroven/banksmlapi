package com.sebastianrod.banksmlapi.service;

import com.sebastianrod.banksmlapi.interfaces.LoanInterface;
import com.sebastianrod.banksmlapi.models.Loan;
import com.sebastianrod.banksmlapi.models.LoanState;
import com.sebastianrod.banksmlapi.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class LoanService implements LoanInterface {

    @Autowired
    public LoanRepository repository;

    @Override
    public Collection<Loan> getAll() {
        return repository.findByStateTrue();
    }

    @Override
    public Loan getById(Integer id) {
        try {
            return repository.findByIdState(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Loan create(Loan loan) {
        return repository.save(loan);
    }

    @Override
    public Loan update(Integer id, Loan loan) {
        loan.setId(id);
        return repository.save(loan);
    }

    @Override
    public Loan delete(Integer id) {

        Loan loan = this.getById(id);
        loan.setState(false);
        return repository.save(loan);
    }

    @Override
    public Loan cancelLoan(Integer id) {

        Loan loan = repository.findByIdState(id).get();

        loan.setLoanState(new LoanState(4, "Cancelado", true));

        return repository.save(loan);
    }
}
