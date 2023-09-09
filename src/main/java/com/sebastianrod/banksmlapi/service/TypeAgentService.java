package com.sebastianrod.banksmlapi.service;

import com.sebastianrod.banksmlapi.interfaces.TypeAgentInterface;
import com.sebastianrod.banksmlapi.models.TypeAgent;
import com.sebastianrod.banksmlapi.repository.TypeAgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TypeAgentService implements TypeAgentInterface {

    @Autowired
    public TypeAgentRepository repository;

    @Override
    public Collection<TypeAgent> getAll() {
        return repository.findByStateTrue();
    }

    @Override
    public TypeAgent getById(Integer id) {
        try {
            return repository.findByIdState(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public TypeAgent create(TypeAgent typeAgent) {
        return repository.save(typeAgent);
    }

    @Override
    public TypeAgent update(Integer id, TypeAgent typeAgent) {
        typeAgent.setId(id);
        return repository.save(typeAgent);
    }

    @Override
    public TypeAgent delete(Integer id) {

        TypeAgent typeAgent = this.getById(id);
        typeAgent.setState(false);
        return repository.save(typeAgent);
    }


}
