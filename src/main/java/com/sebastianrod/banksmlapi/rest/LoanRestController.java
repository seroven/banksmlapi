package com.sebastianrod.banksmlapi.rest;

import com.sebastianrod.banksmlapi.models.Loan;
import com.sebastianrod.banksmlapi.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "/loan")
public class LoanRestController {

    @Autowired
    private LoanService service;

    @GetMapping(path = "/all")
    public Collection<Loan> getAll(){
        return service.getAll();
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<Loan> getById(@PathVariable Integer id){
        try {
            Loan loan = service.getById(id);
            if (loan != null) {
                return new ResponseEntity<>(loan, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "create")
    public ResponseEntity<Loan> create(@RequestBody Loan loan){
        try {
            return new ResponseEntity<>(service.create(loan), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path = "update/{id}")
    public ResponseEntity<Loan> update(@RequestBody Loan loan, @PathVariable Integer id){
        try {
            Loan loanInDb = service.getById(id);
            if (loanInDb != null) {
                return new ResponseEntity<>(service.update(id, loan), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path = "delete/{id}")
    public ResponseEntity<Loan> delete(@PathVariable Integer id){
        try {
            Loan loan = service.getById(id);
            if (loan != null) {
                return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "cancel/{id}")
    public ResponseEntity<Loan> cancelLoan(@PathVariable Integer id){
        try {
            Loan loan = service.getById(id);
            if (loan != null) {
                return new ResponseEntity<>(service.cancelLoan(id), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
