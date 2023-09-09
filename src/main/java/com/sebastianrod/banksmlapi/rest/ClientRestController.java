package com.sebastianrod.banksmlapi.rest;

import com.sebastianrod.banksmlapi.models.Client;
import com.sebastianrod.banksmlapi.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "/client")
public class ClientRestController {

    @Autowired
    private ClientService service;

    @GetMapping(path = "/all")
    public Collection<Client> getAll(){
        return service.getAll();
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<Client> getById(@PathVariable Integer id){
        try {
            Client client = service.getById(id);
            if (client != null) {
                return new ResponseEntity<>(client, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "create")
    public ResponseEntity<Client> create(@RequestBody Client client){
        try {
            return new ResponseEntity<>(service.create(client), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path = "update/{id}")
    public ResponseEntity<Client> update(@RequestBody Client client, @PathVariable Integer id){
        try {
            Client clientInDb = service.getById(id);
            if (clientInDb != null) {
                return new ResponseEntity<>(service.update(id, client), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path = "delete/{id}")
    public ResponseEntity<Client> delete(@PathVariable Integer id){
        try {
            Client client = service.getById(id);
            if (client != null) {
                return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
