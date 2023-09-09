package com.sebastianrod.banksmlapi.repository;

import com.sebastianrod.banksmlapi.models.Agent;
import com.sebastianrod.banksmlapi.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Collection<Client> findByStateTrue();

    @Query(value = "SELECT * FROM clients WHERE state = 1 AND id = :id", nativeQuery = true)
    Optional<Client> findByIdState(@Param(value = "id") Integer id);

}
