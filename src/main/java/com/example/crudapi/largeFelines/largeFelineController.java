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
    private List<largeFeline> felines;

    public void addSomeFelines() {
        service.createFeline(new largeFeline("Lion", "Savannah", 420.0, "Large social cat", 20000));
        service.createFeline(new largeFeline("Tiger", "Forest", 500.0, "Largest cat species", 3900));
        service.createFeline(new largeFeline("Leopard", "Forest", 200.0, "Spotted big cat", 700000));
        service.createFeline(new largeFeline("Cheetah", "Savannah", 150.0, "Fastest land animal", 7100));
    }

    @GetMapping("/felines")
    public ResponseEntity<Object> getAllFelines() {
        addSomeFelines();
        return new ResponseEntity<>(service.getAllFelines(), HttpStatus.OK);
    }

    @GetMapping("/felines/{id}")
    public ResponseEntity<Object> getFelineById(@PathVariable Long felineId) {
        largeFeline feline = (largeFeline) service.getFelineById(felineId);
        if (feline != null) {  
            return new ResponseEntity<>(feline, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Feline not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/felines")
    public ResponseEntity<Object> createFeline(@RequestBody largeFeline feline) {
        largeFeline createdFeline = (largeFeline) service.createFeline(feline);
        return new ResponseEntity<>(createdFeline, HttpStatus.CREATED);
    }

    @PutMapping("/felines/{id}")
    public ResponseEntity<Object> updateFeline(@PathVariable Long felineId, @RequestBody largeFeline feline) {
        largeFeline existingFeline = (largeFeline) service.getFelineById(felineId);
        if (existingFeline != null) {
            feline.setId(felineId);
            service.updateFeline(felineId, feline);
            return new ResponseEntity<>(feline, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Feline not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/felines/{id}")
    public ResponseEntity<Object> deleteFeline(@PathVariable Long felineId) {
       largeFeline existingFeline = (largeFeline) service.getFelineById(felineId);
        if (existingFeline != null) {
            service.deleteFeline(felineId);
            return new ResponseEntity<>("Feline deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Feline not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/felines/name")
    public ResponseEntity<Object> getFelinesByName(@RequestParam(required = false) String name) {
       largeFeline feline = (largeFeline) service.getFelinesByName(name);
       if (name != null) {
            return new ResponseEntity<>(feline, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Feline not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/felines/habitat")
    public ResponseEntity<Object> getFelinesByHabitat(@RequestParam String habitat) {
       new ArrayList<>(habitats);
       for (largeFeline feline : felines) {
           if (feline.getHabitat().equalsIgnoreCase(habitat)) {
               habitat.add(feline);
           }
       }
         if (habitat != null) {
                return new ResponseEntity<>(habitat, HttpStatus.OK);
          }
    }

    @GetMapping("/felines/population")
    public ResponseEntity<Object> getFelinesByPopulationGreaterThan(@RequestParam Integer population) {
        largeFeline feline = (largeFeline) service.getFelinesByPopulationGreaterThan(population);
       if (feline != null) {
            return new ResponseEntity<>(feline, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Feline not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/felines/weight")
    public ResponseEntity<Object> getFelinesByWeightGreaterThan(@RequestParam Double weight) {
        largeFeline feline = (largeFeline) service.getFelinesByWeightGreatherThan(weight);
       if (feline != null) {
            return new ResponseEntity<>(feline, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Feline not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/writeFile")
    public ResponseEntity<String> writeJson(@RequestBody largeFeline feline) {
        try {
            service.writeJson(feline);
            return ResponseEntity.ok("Feline written to JSON successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to write feline to JSON: " + e.getMessage());
        }
    }

    @GetMapping("/readFile")
    public ResponseEntity<List<largeFeline>> readJson() {
        try {
            List<largeFeline> feline =(List<largeFeline>) largeFelineService.readJson();
            return ResponseEntity.ok(felines);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}