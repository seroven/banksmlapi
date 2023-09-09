package com.sebastianrod.banksmlapi.rest;

import com.sebastianrod.banksmlapi.models.TypeAgent;
import com.sebastianrod.banksmlapi.service.TypeAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "/typeAgent")
public class TypeAgentRestController {

    @Autowired
    private TypeAgentService service;

    @GetMapping(path = "/all")
    public Collection<TypeAgent> getAll(){
        return service.getAll();
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<TypeAgent> getById(@PathVariable Integer id){
        try {
            TypeAgent typeAgent = service.getById(id);
            if (typeAgent != null) {
                return new ResponseEntity<>(typeAgent, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "create")
    public ResponseEntity<TypeAgent> create(@RequestBody TypeAgent typeAgent){
        try {
            return new ResponseEntity<>(service.create(typeAgent), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path = "update/{id}")
    public ResponseEntity<TypeAgent> update(@RequestBody TypeAgent typeAgent, @PathVariable Integer id){
        try {
            TypeAgent typeAgentInDb = service.getById(id);
            if (typeAgentInDb != null) {
                return new ResponseEntity<>(service.update(id, typeAgent), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path = "delete/{id}")
    public ResponseEntity<TypeAgent> delete(@PathVariable Integer id){
        try {
            TypeAgent typeAgent = service.getById(id);
            if (typeAgent != null) {
                return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
