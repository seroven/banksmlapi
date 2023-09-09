package com.sebastianrod.banksmlapi.service;

import com.sebastianrod.banksmlapi.interfaces.AgentInterface;
import com.sebastianrod.banksmlapi.models.Agent;
import com.sebastianrod.banksmlapi.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Collection;

@Service
public class AgentService implements AgentInterface {

    @Autowired
    public AgentRepository repository;

    @Override
    public Collection<Agent> getAll() {
        return repository.findByStateTrue();
    }

    @Override
    public Agent getById(Integer id) {
        try {
            return repository.findByIdState(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Agent create(Agent agent) {
        return repository.save(agent);
    }

    @Override
    public Agent update(Integer id, Agent agent) {
        agent.setId(id);
        return repository.save(agent);
    }

    @Override
    public Agent delete(Integer id) {

        Agent agent = this.getById(id);
        agent.setState(false);
        return repository.save(agent);
    }


}
