package com.luigisback.kaizen_api.entity.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class HabitRequestDTO {
    @NotBlank
    private String name;
    private String description;
    @Min(1)
    private int frequency;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getFrequency() {
        return frequency;
    }

    public HabitRequestDTO(String name, String description, int frequency) {
        this.name = name;
        this.description = description;
        this.frequency = frequency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
    public HabitRequestDTO() {
    }
}
