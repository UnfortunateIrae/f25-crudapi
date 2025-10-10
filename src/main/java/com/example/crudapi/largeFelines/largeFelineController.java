package com.example.crudapi.largeFelines;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class largeFelineController {

    @Autowired
    private largeFelineService service;

    public void init() {
        service.createFeline(new largeFeline("Lion", "Savannah", 420.0, "Large social cat", 20000));
        service.createFeline(new largeFeline("Tiger", "Forest", 500.0, "Largest cat species", 3900));
        service.createFeline(new largeFeline("Leopard", "Forest", 200.0, "Spotted big cat", 700000));
        service.createFeline(new largeFeline("Cheetah", "Savannah", 150.0, "Fastest land animal", 7100));
    }

    @GetMapping("/felines")
    public ResponseEntity<Object> getAllFelines() {
        return ResponseEntity.ok(service.getAllFelines());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getFelineById(@PathVariable("id") Long id) {
        largeFeline feline = (largeFeline) service.getFelineById(id);
        return (feline != null)
                ? ResponseEntity.ok(feline)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Feline not found");
    }

    @PostMapping
    public ResponseEntity<Object> createFeline(@RequestBody largeFeline feline) {
        largeFeline created = (largeFeline) service.createFeline(feline);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateFeline(@PathVariable("id") Long id, @RequestBody largeFeline feline) {
        largeFeline existing = (largeFeline) service.getFelineById(id);
        if (existing != null) {
            feline.setId(id);
            service.updateFeline(id, feline);
            return ResponseEntity.ok(feline);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Feline not found");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteFeline(@PathVariable("id") Long id) {
        largeFeline existing = (largeFeline) service.getFelineById(id);
        if (existing != null) {
            service.deleteFeline(id);
            return ResponseEntity.ok("Feline deleted successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Feline not found");
    }

    @GetMapping("/name")
    public ResponseEntity<Object> getFelinesByName(@RequestParam String name) {
        Object result = service.getFelinesByName(name);
        return (result != null)
                ? ResponseEntity.ok(result)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("No felines found with that name");
    }

    @GetMapping("/habitat")
    public ResponseEntity<Object> getFelinesByHabitat(@RequestParam String habitat) {
        List<largeFeline> result = new ArrayList<>();
        for (largeFeline feline : (List<largeFeline>) service.getAllFelines()) {
            if (feline.getHabitat().equalsIgnoreCase(habitat)) {
                result.add(feline);
            }
        }
        return result.isEmpty()
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("No felines found in that habitat")
                : ResponseEntity.ok(result);
    }

    @GetMapping("/population")
    public ResponseEntity<Object> getFelinesByPopulationGreaterThan(@RequestParam String population) {
        try {
            int pop = Integer.parseInt(population);
            List<largeFeline> result = service.getFelinesByPopulationGreaterThan(pop);
            if (result == null || result.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No felines found with population greater than " + pop);
            }
            return ResponseEntity.ok(result);
        } catch (NumberFormatException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Invalid population value: " + population);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Server error: " + e.getMessage());
        }
    }

    @GetMapping("/weight")
    public ResponseEntity<Object> getFelinesByWeightGreaterThan(@RequestParam String weight) {
        try {
            double w = Double.parseDouble(weight);
            List<largeFeline> result = service.getFelinesByWeightGreaterThan(w);
            if (result == null || result.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No felines found with weight greater than " + w);
            }
            return ResponseEntity.ok(result);
        } catch (NumberFormatException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Invalid weight value: " + weight);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Server error: " + e.getMessage());
        }
    }

    @PostMapping("/writeFile")
    public ResponseEntity<String> writeJson(@RequestBody largeFeline feline) {
        try {
            service.writeJson(feline);
            return ResponseEntity.ok("Feline written to JSON successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to write feline to JSON: " + e.getMessage());
        }
    }

    @GetMapping("/readFile")
    public ResponseEntity<Object> readJson() {
        try {
            return ResponseEntity.ok(largeFelineService.readJson());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to read file");
        }
    }
}