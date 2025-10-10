package com.example.crudapi.largeFelines;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class largeFelineService {

    @Autowired
    private largeFelineRepository repository;

    private List<largeFeline> inMemoryList = new ArrayList<>();

    public List<largeFeline> getAllFelines() {
        List<largeFeline> result = new ArrayList<>();
        result.addAll(inMemoryList);
        result.addAll(repository.findAll());
        return result;
    }

    public Object getFelineById(Long id) {
        return repository.findById(id).orElse(
                inMemoryList.stream().filter(f -> f.getId().equals(id)).findFirst().orElse(null));
    }

    public Object createFeline(largeFeline feline) {
        inMemoryList.add(feline);
        return repository.save(feline);
    }

    public void updateFeline(Long id, largeFeline updatedFeline) {
        repository.findById(id).ifPresent(existing -> {
            updatedFeline.setId(id);
            repository.save(updatedFeline);
        });

        for (int i = 0; i < inMemoryList.size(); i++) {
            if (inMemoryList.get(i).getId().equals(id)) {
                inMemoryList.set(i, updatedFeline);
                break;
            }
        }
    }

    public void deleteFeline(Long id) {
        repository.deleteById(id);
        inMemoryList.removeIf(f -> f.getId().equals(id));
    }

    public List<largeFeline> getFelinesByName(String name) {
        List<largeFeline> result = new ArrayList<>();
        for (largeFeline f : inMemoryList) {
            if (f.getName().equalsIgnoreCase(name))
                result.add(f);
        }
        for (largeFeline f : repository.findAll()) {
            if (f.getName().equalsIgnoreCase(name))
                result.add(f);
        }
        return result;
    }

    public List<largeFeline> getFelinesByPopulationGreaterThan(Integer population) {
        return repository.findAll().stream()
                .filter(f -> f.getPopulation() > population)
                .toList(); // Java 16+; use .collect(Collectors.toList()) if older
    }

    public List<largeFeline> getFelinesByWeightGreaterThan(Double weight) {
        return repository.findAll().stream()
                .filter(f -> f.getWeight() > weight)
                .toList(); // or .collect(Collectors.toList())
    }

    public void writeJson(largeFeline feline) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("felines.json");
            List<largeFeline> list = (List<largeFeline>) readJson();
            list.add(feline);
            mapper.writeValue(file, list);
        } catch (Exception e) {
            throw new RuntimeException("JSON write failed", e);
        }
    }

    public static Object readJson() {
        try {
            File file = new File("felines.json");
            if (!file.exists())
                return new ArrayList<>();
            String json = new String(Files.readAllBytes(file.toPath()));
            ObjectMapper mapper = new ObjectMapper();
            return List.of(mapper.readValue(json, largeFeline[].class));
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
