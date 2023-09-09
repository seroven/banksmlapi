package com.sebastianrod.banksmlapi.repository;

import com.sebastianrod.banksmlapi.models.Agent;
import com.sebastianrod.banksmlapi.models.Due;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;
@Repository
public interface DueRepository extends JpaRepository<Due, Integer> {
    Collection<Due> findByStateTrue();
    @Query(value = "SELECT * FROM dues WHERE state = 1 AND id_loan = :id", nativeQuery = true)
    Collection<Due> findByIdLoan(Integer id);

    @Query(value = "SELECT * FROM dues WHERE state = 1 AND id = :id", nativeQuery = true)
    Optional<Due> findByIdState(@Param(value = "id") Integer id);

}
