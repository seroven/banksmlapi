package com.sebastianrod.banksmlapi.repository;

import com.sebastianrod.banksmlapi.models.Agent;
import com.sebastianrod.banksmlapi.models.TypeAgent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;
@Repository
public interface TypeAgentRepository extends JpaRepository<TypeAgent, Integer> {
    Collection<TypeAgent> findByStateTrue();

    @Query(value = "SELECT * FROM type_agent WHERE state = 1 AND id = :id", nativeQuery = true)
    Optional<TypeAgent> findByIdState(@Param(value = "id") Integer id);

}
