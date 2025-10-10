package com.example.crudapi.largeFelines;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class largeFelineService {
    @Autowired
    private largeFelineRepository repository;

    private ArrayList<largeFeline> felines = new ArrayList<>();

    public Object getAllFelines() {
        return felines;
    }
    public Object getFelineById(@PathVariable Long id) {
        return felines.stream().filter(f -> f.getId().equals(id)).findFirst().orElse(null);
    }

    public Object createFeline(largeFeline feline) {
        felines.add(feline);
        return repository.save(feline);
    }

    public Object updateFeline(Long id, largeFeline feline) {
        for (int i = 0; i < felines.size(); i++) {
            if (felines.get(i).getId().equals(id)) {
                felines.set(i, feline);
                return repository.save(feline);
            }
        }
        return null;
    }

    public void deleteFeline(Long id) {
        felines.removeIf(f -> f.getId().equals(id));
        repository.deleteById(id);
    }

    public Object getFelinesByName(String name) {
        return repository.findByName(name);
    }

    public Object getFelinesByHabitat(String habitat) {
        return repository.getByHabitat(habitat);
    }
    public Object getFelinesByPopulationGreaterThan(Integer population) {
        return repository.getByPopulationGreaterThan(population);
    }

    public Object getFelinesByWeightGreatherThan(Double weight) {
        return repository.getByWeightGreaterThan(weight);
    }
}