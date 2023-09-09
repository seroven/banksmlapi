package com.sebastianrod.banksmlapi.repository;

import com.sebastianrod.banksmlapi.models.Agent;
import com.sebastianrod.banksmlapi.models.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;
@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {
    Collection<Loan> findByStateTrue();

    @Query(value = "SELECT * FROM loans WHERE state = 1 AND id = :id", nativeQuery = true)
    Optional<Loan> findByIdState(@Param(value = "id") Integer id);

}
