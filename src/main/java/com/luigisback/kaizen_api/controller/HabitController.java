package com.luigisback.kaizen_api.controller;

import com.luigisback.kaizen_api.entity.HabitLog;
import com.luigisback.kaizen_api.entity.dto.HabitLogResponseDTO;
import com.luigisback.kaizen_api.entity.dto.HabitRequestDTO;
import com.luigisback.kaizen_api.entity.dto.HabitResponseDTO;
import com.luigisback.kaizen_api.service.HabitService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.luigisback.kaizen_api.service.HabitLogService;

import java.util.List;

@RestController
public class HabitController {

    public final HabitService habitService;
    public final HabitLogService habitLogService;

    public HabitController(HabitService habitService, HabitLogService habitLogService) {
        this.habitService = habitService;
        this.habitLogService = habitLogService;
    }

    @GetMapping("api/habits")
    public List<HabitResponseDTO> getAllHabit() {
        return habitService.getAllHabits();
    }

    @PostMapping("/api/habits")
    public ResponseEntity<HabitResponseDTO> createHabit(
            @Valid @RequestBody HabitRequestDTO habit) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(habitService.saveHabit(habit));
    }

    @GetMapping("/api/habits/{id}")
    public HabitResponseDTO getHabitById(@PathVariable Long id) {
        return habitService.getHabitById(id);
    }

    @DeleteMapping("/api/habits/{id}")
    public ResponseEntity<Void> deleteHabit(@PathVariable Long id) {

        habitService.deleteHabit(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/api/habits/{id}")
    public HabitResponseDTO updateHabits(
            @PathVariable Long id,
            @Valid @RequestBody HabitRequestDTO habit) {

        return habitService.updateHabit(id, habit);
    }

    @GetMapping("/api/habits/{id}/logs")
    public List<HabitLogResponseDTO> getLogsByHabitId(@PathVariable Long id){
        return habitLogService.getLogsByHabitId(id);
    }

    @GetMapping("/api/habits/{id}/count")
    public long countLogsByHabitId(@PathVariable Long id) {
        return habitLogService.countLogsByHabitId(id);
    }

    @GetMapping("/api/habits/{id}/streak")
    public long getCurrentStreak(@PathVariable Long id) {
        return habitLogService.getCurrentStreak(id);
    }
}