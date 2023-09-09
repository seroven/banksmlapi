package com.sebastianrod.banksmlapi.interfaces;

import com.sebastianrod.banksmlapi.models.Loan;

import java.util.Collection;

public interface LoanInterface {

  Collection<Loan> getAll();
  Loan getById(Integer id);
  Loan cancelLoan(Integer id);
  Loan create(Loan loan);
  Loan update(Integer id, Loan loan);
  Loan delete(Integer id);

}
