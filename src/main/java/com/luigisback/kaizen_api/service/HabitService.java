package com.luigisback.kaizen_api.service;

import com.luigisback.kaizen_api.entity.Habit;
import com.luigisback.kaizen_api.entity.dto.HabitRequestDTO;
import com.luigisback.kaizen_api.entity.dto.HabitResponseDTO;
import com.luigisback.kaizen_api.exception.HabitNotFoundException;
import com.luigisback.kaizen_api.repository.HabitRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class HabitService {

    private final HabitRepository habitRepository;

    public HabitService(HabitRepository habitRepository) {
        this.habitRepository = habitRepository;
    }

    public List<HabitResponseDTO> getAllHabits() {

        return habitRepository.findAll()
                .stream()
                .map(habit -> new HabitResponseDTO(
                        habit.getId(),
                        habit.getName(),
                        habit.getDescription(),
                        habit.getFrequency()
                ))
                .toList();
    }

    public HabitResponseDTO saveHabit(HabitRequestDTO habitDTO) {

        Habit habit = new Habit();

        habit.setName(habitDTO.getName());
        habit.setDescription(habitDTO.getDescription());
        habit.setFrequency(habitDTO.getFrequency());

        Habit savedHabit = habitRepository.save(habit);

        return new HabitResponseDTO(
                savedHabit.getId(),
                savedHabit.getName(),
                savedHabit.getDescription(),
                savedHabit.getFrequency()
        );
    }

    public HabitResponseDTO getHabitById(Long id) {

        return habitRepository.findById(id)
                .map(habit -> new HabitResponseDTO(
                        habit.getId(),
                        habit.getName(),
                        habit.getDescription(),
                        habit.getFrequency()
                ))
                .orElseThrow(() ->
                        new HabitNotFoundException("Hábito no encontrado"));
    }

    public void deleteHabit(Long id) {

        Habit habit = habitRepository.findById(id)
                .orElseThrow(() ->
                        new HabitNotFoundException("No encontrado"));

        habitRepository.delete(habit);
    }

    public HabitResponseDTO updateHabit(
            Long id,
            HabitRequestDTO updatedHabit) {

        Habit habit = habitRepository.findById(id)
                .orElseThrow(() ->
                        new HabitNotFoundException("Hábito no encontrado"));

        habit.setName(updatedHabit.getName());
        habit.setDescription(updatedHabit.getDescription());
        habit.setFrequency(updatedHabit.getFrequency());

        Habit savedHabit = habitRepository.save(habit);

        return new HabitResponseDTO(
                savedHabit.getId(),
                savedHabit.getName(),
                savedHabit.getDescription(),
                savedHabit.getFrequency()
        );
    }
}