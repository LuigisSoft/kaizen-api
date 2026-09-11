package com.luigisback.kaizen_api.entity.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class HabitLogRequestDTO {

    @NotNull
    private LocalDate date;

    @NotNull
    private Long habitId;

    public HabitLogRequestDTO() {
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getHabitId() {
        return habitId;
    }

    public void setHabitId(Long habitId) {
        this.habitId = habitId;
    }
}