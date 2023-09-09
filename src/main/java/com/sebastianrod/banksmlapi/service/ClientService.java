package com.sebastianrod.banksmlapi.service;

import com.sebastianrod.banksmlapi.interfaces.ClientInterface;
import com.sebastianrod.banksmlapi.models.Client;
import com.sebastianrod.banksmlapi.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ClientService implements ClientInterface {

    @Autowired
    public ClientRepository repository;

    @Override
    public Collection<Client> getAll() {
        return repository.findByStateTrue();
    }

    @Override
    public Client getById(Integer id) {
        try {
            return repository.findByIdState(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Client create(Client client) {
        return repository.save(client);
    }

    @Override
    public Client update(Integer id, Client client) {
        client.setId(id);
        return repository.save(client);
    }

    @Override
    public Client delete(Integer id) {

        Client client = this.getById(id);
        client.setState(false);
        return repository.save(client);
    }


}
