package com.sebastianrod.banksmlapi.service;

import com.sebastianrod.banksmlapi.interfaces.DueStateInterface;
import com.sebastianrod.banksmlapi.models.DueState;
import com.sebastianrod.banksmlapi.repository.DueStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DueStateService implements DueStateInterface {

    @Autowired
    public DueStateRepository repository;

    @Override
    public Collection<DueState> getAll() {
        return repository.findByStateTrue();
    }

    @Override
    public DueState getById(Integer id) {
        try {
            return repository.findByIdState(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public DueState create(DueState dueState) {
        return repository.save(dueState);
    }

    @Override
    public DueState update(Integer id, DueState dueState) {
        dueState.setId(id);
        return repository.save(dueState);
    }

    @Override
    public DueState delete(Integer id) {

        DueState dueState = this.getById(id);
        dueState.setState(false);
        return repository.save(dueState);
    }


}
