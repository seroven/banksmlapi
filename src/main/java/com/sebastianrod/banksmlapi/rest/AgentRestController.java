package com.sebastianrod.banksmlapi.rest;

import com.sebastianrod.banksmlapi.models.Agent;
import com.sebastianrod.banksmlapi.models.TypeAgent;
import com.sebastianrod.banksmlapi.repository.TypeAgentRepository;
import com.sebastianrod.banksmlapi.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "/agent")
public class AgentRestController {

    @Autowired
    private AgentService service;

    @GetMapping(path = "/all")
    public Collection<Agent> getAll(){
        return service.getAll();
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<Agent> getById(@PathVariable Integer id){
        try {
            Agent agent = service.getById(id);
            if (agent != null) {
                return new ResponseEntity<>(agent, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "create")
    public ResponseEntity<Agent> create(@RequestBody Agent agent){
        try {
            return new ResponseEntity<>(service.create(agent), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path = "update/{id}")
    public ResponseEntity<Agent> update(@RequestBody Agent agent, @PathVariable Integer id){
        try {
            System.out.println(id);
            Agent agentInDb = service.getById(id);
            if (agentInDb != null) {
                return new ResponseEntity<>(service.update(id, agent), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path = "delete/{id}")
    public ResponseEntity<Agent> delete(@PathVariable Integer id){
        try {
            Agent agent = service.getById(id);
            if (agent != null) {
                return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
