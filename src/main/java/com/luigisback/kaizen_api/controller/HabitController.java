package com.luigisback.kaizen_api.controller;

import com.luigisback.kaizen_api.entity.Habit;
import com.luigisback.kaizen_api.entity.HabitLog;
import com.luigisback.kaizen_api.service.HabitService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.luigisback.kaizen_api.service.HabitLogService;
import com.luigisback.kaizen_api.entity.HabitLog;

import java.util.List;

@RestController
public class HabitController {

    public final HabitService habitService;
    public final HabitLogService habitLogService;

    public HabitController(HabitService habitService, HabitLogService habitLogService) {
        this.habitService=habitService;
        this.habitLogService=habitLogService;
    }

    @GetMapping("api/habits")
    public List<Habit> getAllHabit(){

        return habitService.getAllHabits();
    }

    @PostMapping("/api/habits")
    public Habit createHabit(@Valid @RequestBody Habit habit){
        return habitService.saveHabit(habit);
    }

    @GetMapping("/api/habits/{id}")
    public Habit getHabitlById(@PathVariable Long id){
        return habitService.getHabitById(id);

    }

    @DeleteMapping("/api/habits/{id}")
    public void deleteHabit(@PathVariable Long id){
        habitService.deleteHabit(id);
    }

    @PutMapping("/api/habits/{id}")
    public Habit updateHabits(@PathVariable Long id,
                           @RequestBody Habit habit){
        return habitService.updateHabit(id, habit);
    }
    @GetMapping("/api/habits/{id}/logs")
    public List<HabitLog> getLogsByHabitId(@PathVariable Long id){
        return habitLogService.getLogsByHabitId(id);
    }
    @GetMapping("/api/habits/{id}/count")
    public long countLogsByHabitId(@PathVariable Long id){
        return habitLogService.countLogsByHabitId(id);
    }




}
