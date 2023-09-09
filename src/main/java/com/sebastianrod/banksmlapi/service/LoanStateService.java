package com.sebastianrod.banksmlapi.service;

import com.sebastianrod.banksmlapi.interfaces.LoanStateInterface;
import com.sebastianrod.banksmlapi.models.LoanState;
import com.sebastianrod.banksmlapi.repository.LoanStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class LoanStateService implements LoanStateInterface {

    @Autowired
    public LoanStateRepository repository;

    @Override
    public Collection<LoanState> getAll() {
        return repository.findByStateTrue();
    }

    @Override
    public LoanState getById(Integer id) {
        try {
            return repository.findByIdState(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public LoanState create(LoanState loanState) {
        return repository.save(loanState);
    }

    @Override
    public LoanState update(Integer id, LoanState loanState) {
        loanState.setId(id);
        return repository.save(loanState);
    }

    @Override
    public LoanState delete(Integer id) {

        LoanState loanState = this.getById(id);
        loanState.setState(false);
        return repository.save(loanState);
    }


}
