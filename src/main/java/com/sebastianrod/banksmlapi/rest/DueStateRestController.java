package com.sebastianrod.banksmlapi.rest;

import com.sebastianrod.banksmlapi.models.DueState;
import com.sebastianrod.banksmlapi.service.DueStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "/dueState")
public class DueStateRestController {

    @Autowired
    private DueStateService service;

    @GetMapping(path = "/all")
    public Collection<DueState> getAll(){
        return service.getAll();
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<DueState> getById(@PathVariable Integer id){
        try {
            DueState dueState = service.getById(id);
            if (dueState != null) {
                return new ResponseEntity<>(dueState, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "create")
    public ResponseEntity<DueState> create(@RequestBody DueState dueState){
        try {
            return new ResponseEntity<>(service.create(dueState), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path = "update/{id}")
    public ResponseEntity<DueState> update(@RequestBody DueState dueState, @PathVariable Integer id){
        try {
            DueState dueStateInDb = service.getById(id);
            if (dueStateInDb != null) {
                return new ResponseEntity<>(service.update(id, dueState), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path = "delete/{id}")
    public ResponseEntity<DueState> delete(@PathVariable Integer id){
        try {
            DueState dueState = service.getById(id);
            if (dueState != null) {
                return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
