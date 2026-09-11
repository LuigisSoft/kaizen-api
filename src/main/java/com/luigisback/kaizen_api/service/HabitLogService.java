package com.luigisback.kaizen_api.service;

import com.luigisback.kaizen_api.entity.Habit;
import com.luigisback.kaizen_api.entity.HabitLog;
import com.luigisback.kaizen_api.entity.dto.HabitLogRequestDTO;
import com.luigisback.kaizen_api.entity.dto.HabitLogResponseDTO;
import com.luigisback.kaizen_api.exception.HabitLogAlreadyExistsException;
import com.luigisback.kaizen_api.exception.HabitNotFoundException;
import com.luigisback.kaizen_api.repository.HabitLogRepository;
import com.luigisback.kaizen_api.repository.HabitRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class HabitLogService {

    private final HabitRepository habitRepository;
    private final HabitLogRepository habitLogRepository;

    public HabitLogService(HabitLogRepository habitLogRepository,
                           HabitRepository habitRepository) {
        this.habitLogRepository = habitLogRepository;
        this.habitRepository = habitRepository;
    }

    public HabitLogResponseDTO saveHabitLogs(HabitLogRequestDTO habitLogDTO) {

        Habit habit = habitRepository.findById(habitLogDTO.getHabitId())
                .orElseThrow(() ->
                        new HabitNotFoundException("Hábito no encontrado"));

        if (habitLogRepository.existsByHabitIdAndDate(
                habitLogDTO.getHabitId(),
                habitLogDTO.getDate())) {

            throw new HabitLogAlreadyExistsException(
                    "El hábito ya esta registrado para este día");
        }

        HabitLog habitLog = new HabitLog();

        habitLog.setDate(habitLogDTO.getDate());
        habitLog.setHabit(habit);

        HabitLog savedHabitLog = habitLogRepository.save(habitLog);

        return new HabitLogResponseDTO(
                savedHabitLog.getId(),
                savedHabitLog.getDate(),
                savedHabitLog.getHabit().getId()
        );
    }

    public List<HabitLogResponseDTO> getAllLogs() {
        return habitLogRepository.findAll()
                .stream()
                .map(habitLog -> new HabitLogResponseDTO(
                    habitLog.getId(),
                        habitLog.getDate(),
                        habitLog.getHabit().getId()
                ))
                .toList();
    }

    public List<HabitLogResponseDTO> getLogsByHabitId(Long habitId) {
        return habitLogRepository.findByHabitIdOrderByDateDesc(habitId)
                .stream()
                .map(habitLog -> new HabitLogResponseDTO(
                        habitLog.getId(),
                        habitLog.getDate(),
                        habitLog.getHabit().getId()
                ))
                .toList();



    }

    public long countLogsByHabitId(Long habitId) {
        return habitLogRepository.countByHabitId(habitId);
    }

    public HabitLogResponseDTO getHabitLogById(Long id) {

        HabitLog habitLog = habitLogRepository.findById(id)
                .orElseThrow(() ->
                        new HabitNotFoundException("Registro no encontrado"));

        return new HabitLogResponseDTO(
                habitLog.getId(),
                habitLog.getDate(),
                habitLog.getHabit().getId()
        );
    }

    public void deleteHabitLog(Long id) {

        HabitLog habitLog = habitLogRepository.findById(id)
                .orElseThrow(() ->
                        new HabitNotFoundException("Registro no encontrado"));

    }

    public long getCurrentStreak(Long habitId) {

        habitRepository.findById(habitId)
                .orElseThrow(() ->
                        new HabitNotFoundException("Hábito no encontrado"));

        List<HabitLog> logs =
                habitLogRepository.findByHabitIdOrderByDateDesc(habitId);

        if (logs.isEmpty()) {
            return 0;
        }

        LocalDate lastDate = logs.get(0).getDate();
        LocalDate today = LocalDate.now();

        if (lastDate.isBefore(today.minusDays(1))) {
            return 0;
        }

        long streak = 1;

        for (int i = 0; i < logs.size() - 1; i++) {

            if (logs.get(i).getDate().minusDays(1)
                    .equals(logs.get(i + 1).getDate())) {

                streak++;

            } else {
                break;
            }
        }

        return streak;
    }
}