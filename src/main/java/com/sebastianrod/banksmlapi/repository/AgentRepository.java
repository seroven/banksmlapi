package com.sebastianrod.banksmlapi.repository;

import com.sebastianrod.banksmlapi.models.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;
@Repository
public interface AgentRepository extends JpaRepository<Agent, Integer> {
    Collection<Agent> findByStateTrue();

    @Query(value = "SELECT * FROM agents WHERE id = :id", nativeQuery = true)
    Optional<Agent> findByIdState(@Param(value = "id") Integer id);

}
