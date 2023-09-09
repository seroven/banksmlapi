package com.sebastianrod.banksmlapi.rest;

import com.sebastianrod.banksmlapi.models.LoanState;
import com.sebastianrod.banksmlapi.service.LoanStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "/loanState")
public class LoanStateRestController {

    @Autowired
    private LoanStateService service;

    @GetMapping(path = "/all")
    public Collection<LoanState> getAll(){
        return service.getAll();
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<LoanState> getById(@PathVariable Integer id){
        try {
            LoanState loanState = service.getById(id);
            if (loanState != null) {
                return new ResponseEntity<>(loanState, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "create")
    public ResponseEntity<LoanState> create(@RequestBody LoanState loanState){
        try {
            return new ResponseEntity<>(service.create(loanState), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path = "update/{id}")
    public ResponseEntity<LoanState> update(@RequestBody LoanState loanState, @PathVariable Integer id){
        try {
            LoanState loanStateInDb = service.getById(id);
            if (loanStateInDb != null) {
                return new ResponseEntity<>(service.update(id, loanState), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path = "delete/{id}")
    public ResponseEntity<LoanState> delete(@PathVariable Integer id){
        try {
            LoanState loanState = service.getById(id);
            if (loanState != null) {
                return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
