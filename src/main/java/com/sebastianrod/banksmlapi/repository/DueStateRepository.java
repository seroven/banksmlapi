package com.sebastianrod.banksmlapi.repository;

import com.sebastianrod.banksmlapi.models.Agent;
import com.sebastianrod.banksmlapi.models.DueState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;
@Repository
public interface DueStateRepository extends JpaRepository<DueState, Integer> {
    Collection<DueState> findByStateTrue();

    @Query(value = "SELECT * FROM due_state WHERE state = 1 AND id = :id", nativeQuery = true)
    Optional<DueState> findByIdState(@Param(value = "id") Integer id);

}
