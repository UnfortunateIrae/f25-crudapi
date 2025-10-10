package com.example.crudapi.largeFelines;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class largeFelineService {
    @Autowired
    private largeFelineRepository repository;

    public Object getAllFelines() {
        return repository.findAll();
    }

    public Object getFelineById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    public Object createFeline(largeFeline feline) {
        return repository.save(feline);
    }

    public Object updateFeline(Long id, largeFeline feline) {
        return repository.save(feline);
    }

    public void deleteFeline(Long id) {
        repository.findById(id);
    }

    public Object getFelinesByName(String name) {
        return repository.getByName(name);
    }

    public Object getFelinesByHabitat(String habitat) {
        return repository.getByHabitat(habitat);
    }
    public Object getFelinesByPopulationGreaterThan(Integer population) {
        return repository.getByPopulationGreaterThan(population);
    }

    public Object getFelinesByWeightGreatherTham(Double weight) {
        return repository.getByWeightGreaterThan(weight);
    }
}