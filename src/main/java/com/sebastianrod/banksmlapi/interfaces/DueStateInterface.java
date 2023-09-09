package com.sebastianrod.banksmlapi.interfaces;

import com.sebastianrod.banksmlapi.models.DueState;

import java.util.Collection;

public interface DueStateInterface {

  Collection<DueState> getAll();
  DueState getById(Integer id);
  DueState create(DueState dueState);
  DueState update(Integer id, DueState dueState);
  DueState delete(Integer id);

}
