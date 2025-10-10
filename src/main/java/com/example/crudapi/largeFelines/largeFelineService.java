package com.example.crudapi.largeFelines;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class largeFelineService {
    private final static ObjectMapper objectMapper = new ObjectMapper();
    private final static File jsonFile = new File("felines.json");

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

    public void updateFeline(Long id, largeFeline feline) {
        repository.findById(id).ifPresent(existingFeline -> {
            existingFeline.setName(feline.getName());
            existingFeline.setHabitat(feline.getHabitat());
            existingFeline.setWeight(feline.getWeight());
            existingFeline.setDescription(feline.getDescription());
            existingFeline.setPopulation(feline.getPopulation());
            repository.save(existingFeline);
        });
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

    public void writeJson(largeFeline feline) throws Exception {
        Object current = getAllFelines();
        ((ArrayList<largeFeline>) current).add(feline);
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile, current);
    }

    public static Object readJson() throws Exception {
        if (!jsonFile.exists()) return new largeFelineService().getAllFelines();
        return objectMapper.readValue(jsonFile,
                objectMapper.getTypeFactory().constructCollectionType(List.class, largeFeline.class));
    }
}