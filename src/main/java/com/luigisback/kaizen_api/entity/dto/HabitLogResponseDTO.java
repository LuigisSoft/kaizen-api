package com.luigisback.kaizen_api.entity.dto;

import java.time.LocalDate;

public class HabitLogResponseDTO {

    private Long id;
    private LocalDate date;
    private Long habitId;

    public HabitLogResponseDTO(Long id, LocalDate date, Long habitId) {
        this.id = id;
        this.date = date;
        this.habitId = habitId;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public Long getHabitId() {
        return habitId;
    }
}