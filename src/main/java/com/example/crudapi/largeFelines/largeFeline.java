package com.example.crudapi.largeFelines;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "largeFelines")

public class largeFeline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long felineId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "habitat", nullable = false)
    private String habitat;

    @Column(name = "weight", nullable = false)
    private Double weight;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "population", nullable = false)
    private Integer population;

    @Column(name = "imageUrl", nullable = true)
    private String imageUrl;

    // Constructors
    public largeFeline() {
    }

    public largeFeline(String name, String habitat, Double weight, String description, Integer population, String imageUrl) {
        this.name = name;
        this.habitat = habitat;
        this.weight = weight;
        this.description = description;
        this.population = population;
        this.imageUrl = imageUrl;
    }

    // Getters and Setters
    public Long getId() {
        return felineId;
    }

    public void setId(Long id) {
        this.felineId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
