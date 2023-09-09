package com.sebastianrod.banksmlapi.interfaces;

import com.sebastianrod.banksmlapi.models.Agent;

import java.util.Collection;

public interface AgentInterface {

    Collection<Agent> getAll();
    Agent getById(Integer id);
    Agent create(Agent agent);
    Agent update(Integer id, Agent agent);
    Agent delete(Integer id);

}
