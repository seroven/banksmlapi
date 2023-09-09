package com.sebastianrod.banksmlapi.interfaces;

import com.sebastianrod.banksmlapi.models.LoanState;

import java.util.Collection;

public interface LoanStateInterface {

  Collection<LoanState> getAll();
  LoanState getById(Integer id);
  LoanState create(LoanState loanState);
  LoanState update(Integer id, LoanState loanState);
  LoanState delete(Integer id);

}
