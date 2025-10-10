package com.example.crudapi.largeFelines;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface largeFelineRepository extends JpaRepository<largeFeline, Long> {
    List<largeFeline> findByName(String name);
    
    @Query("SELECT lf FROM largeFeline lf WHERE lf.habitat = ?1")
    List<largeFeline> findByHabitat(String habitat);
    
    List<largeFeline> findByPopulationGreaterThan(Integer population);
}