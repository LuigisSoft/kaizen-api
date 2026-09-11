package com.luigisback.kaizen_api.controller;

import com.luigisback.kaizen_api.entity.Habit;
import com.luigisback.kaizen_api.entity.HabitLog;
import com.luigisback.kaizen_api.service.HabitLogService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.luigisback.kaizen_api.entity.dto.HabitLogRequestDTO;
import com.luigisback.kaizen_api.entity.dto.HabitLogResponseDTO;

import java.util.List;

@RestController
public class HabitLogController {

    public final HabitLogService habitLogService;

    public HabitLogController(HabitLogService habitLogService) {
        this.habitLogService = habitLogService;
    }


    @GetMapping("api/habitLogs")
    public List<HabitLogResponseDTO> getAllLogs(){
        return habitLogService.getAllLogs();
    }

    @PostMapping("/api/habitLogs")
    public ResponseEntity<HabitLogResponseDTO> createHabitLog
            (@Valid @RequestBody HabitLogRequestDTO habitLog) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(habitLogService.saveHabitLogs(habitLog));
    }

    @GetMapping("/api/habitLogs/{id}")
    public HabitLogResponseDTO  getHabitLogById(@PathVariable Long id){
        return habitLogService.getHabitLogById(id);
    }

    @DeleteMapping("/api/habitLogs/{id}")
    public   ResponseEntity<Void> deleteHabitLogs(@PathVariable Long id){
        habitLogService.deleteHabitLog(id);
        return ResponseEntity.noContent().build();
    }



}
