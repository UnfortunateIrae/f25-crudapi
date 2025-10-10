package com.example.crudapi.largeFelines;

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

    @GetMapping("/felines")
    public ResponseEntity<Object> getAllFelines() {
        return new ResponseEntity<>(service.getAllFelines(), HttpStatus.OK);
    }

    @GetMapping("/felines/{id}")
    public ResponseEntity<Object> getFelineById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getFelineById(id), HttpStatus.OK);
    }

    @PostMapping("/felines")
    public ResponseEntity<Object> createFeline(@RequestBody largeFeline feline) {
        return new ResponseEntity<>(service.createFeline(feline), HttpStatus.CREATED);
    }

    @PutMapping("/felines/{id}")
    public ResponseEntity<Object> updateFeline(@PathVariable Long id, @RequestBody largeFeline feline) {
        return new ResponseEntity<>(service.updateFeline(id, feline), HttpStatus.OK);
    }

    @DeleteMapping("/felines/{id}")
    public ResponseEntity<Object> deleteFeline(@PathVariable Long id) {
        service.deleteFeline(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/felines/name")
    public ResponseEntity<Object> getFelinesByName(@RequestParam String name) {
        return new ResponseEntity<>(service.getFelinesByName(name), HttpStatus.OK);
    }

    @GetMapping("/felines/habitat")
    public ResponseEntity<Object> getFelinesByHabitat(@RequestParam String habitat) {
        return new ResponseEntity<>(service.getFelinesByHabitat(habitat), HttpStatus.OK);
    }

    @GetMapping("/felines/population")
    public ResponseEntity<Object> getFelinesByPopulationGreaterThan(@RequestParam Integer population) {
        return new ResponseEntity<>(service.getFelinesByPopulationGreaterThan(population), HttpStatus.OK);
    }

    @GetMapping("/felines/weight")
    public ResponseEntity<Object> getFelinesByWeightGreaterThan(@RequestParam Double weight) {
        return new ResponseEntity<>(service.getFelinesByWeightGreatherTham(weight), HttpStatus.OK);
    }
}
