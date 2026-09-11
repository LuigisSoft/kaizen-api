package com.luigisback.kaizen_api.entity.dto;

public class HabitResponseDTO {

    private Long id;
    private String name;
    private String description;
    private int frequency;

    public HabitResponseDTO(Long id, String name, String description, int frequency) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.frequency = frequency;
    }

    public HabitResponseDTO(Long id, Integer frequency) {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getFrequency() {
        return frequency;
    }
}