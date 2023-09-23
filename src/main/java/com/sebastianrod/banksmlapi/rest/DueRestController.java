package com.sebastianrod.banksmlapi.rest;

import com.sebastianrod.banksmlapi.models.Due;
import com.sebastianrod.banksmlapi.service.DueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin
@RequestMapping(path = "/due")
public class DueRestController {

    @Autowired
    private DueService service;

    @GetMapping(path = "all")
    public Collection<Due> getAll(){
        return service.getAll();
    }

    @GetMapping(path = "byLoan/{id}")
    public Collection<Due> getAll(@PathVariable Integer id){
        return service.getAllByLoan(id);
    }

    @GetMapping(path = "id/{id}")
    public ResponseEntity<Due> getById(@PathVariable Integer id){
        try {
            Due due = service.getById(id);
            if (due != null) {
                return new ResponseEntity<>(due, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "create")
    public ResponseEntity<Due> create(@RequestBody Due due){
        try {
            return new ResponseEntity<>(service.create(due), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "pay/{id}")
    public ResponseEntity<Due> pay(@PathVariable Integer id){
        try {
            Due due = service.getById(id);
            if (due != null) {
                return new ResponseEntity<>(service.payDue(id), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path = "update/{id}")
    public ResponseEntity<Due> update(@RequestBody Due due, @PathVariable Integer id){
        try {
            Due dueInDb = service.getById(id);
            if (dueInDb != null) {
                return new ResponseEntity<>(service.update(id, due), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path = "delete/{id}")
    public ResponseEntity<Due> delete(@PathVariable Integer id){
        try {
            Due due = service.getById(id);
            if (due != null) {
                return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
