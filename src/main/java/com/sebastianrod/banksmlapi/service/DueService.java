package com.sebastianrod.banksmlapi.service;

import com.sebastianrod.banksmlapi.interfaces.DueInterface;
import com.sebastianrod.banksmlapi.models.Due;
import com.sebastianrod.banksmlapi.models.DueState;
import com.sebastianrod.banksmlapi.repository.DueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;

@Service
public class DueService implements DueInterface {

    @Autowired
    public DueRepository repository;

    @Override
    public Collection<Due> getAll() {
        return repository.findByStateTrue();
    }

    @Override
    public Due getById(Integer id) {
        try {
            return repository.findByIdState(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Due create(Due due) {
        return repository.save(due);
    }

    @Override
    public Due update(Integer id, Due due) {
        due.setId(id);
        return repository.save(due);
    }

    @Override
    public Due delete(Integer id) {

        Due due = this.getById(id);
        due.setState(false);
        return repository.save(due);
    }

    @Override
    public Due payDue(Integer id) {

        Due due = repository.findByIdState(id).get();

        due.setDueState(new DueState(2, "Pagado", true));
        due.setDate_paid(new Date());
        due.calculateMora();

        return repository.save(due);
    }

    @Override
    public Collection<Due> getAllByLoan(Integer id) {
        return repository.findByIdLoan(id);
    }
}
