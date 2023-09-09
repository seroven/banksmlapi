package com.sebastianrod.banksmlapi.interfaces;

import com.sebastianrod.banksmlapi.models.TypeAgent;

import java.util.Collection;

public interface TypeAgentInterface {

  Collection<TypeAgent> getAll();
  TypeAgent getById(Integer id);
  TypeAgent create(TypeAgent typeAgent);
  TypeAgent update(Integer id, TypeAgent typeAgent);
  TypeAgent delete(Integer id);

}
