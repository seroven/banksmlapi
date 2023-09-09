package com.sebastianrod.banksmlapi.interfaces;

import com.sebastianrod.banksmlapi.models.Due;

import java.util.Collection;

public interface DueInterface {

  Collection<Due> getAll();
  Collection<Due> getAllByLoan(Integer id);
  Due getById(Integer id);
  Due create(Due due);
  Due update(Integer id, Due due);
  Due delete(Integer id);
  Due payDue(Integer id);

}
