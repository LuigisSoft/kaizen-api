package com.luigisback.kaizen_api.entity.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class HabitRequestDTO {

    @NotBlank
    private String name;

    private String description;

    @Min(1)
    private int frequency;

    public HabitRequestDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}