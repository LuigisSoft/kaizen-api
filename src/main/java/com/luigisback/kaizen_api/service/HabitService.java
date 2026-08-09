package com.luigisback.kaizen_api.service;

import com.luigisback.kaizen_api.entity.Habit;
import com.luigisback.kaizen_api.repository.HabitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitService {

    private final HabitRepository habitRepository;

    public HabitService(HabitRepository habitRepository){
        this.habitRepository=habitRepository;

    }

    public List<Habit> getAllHabits(){
        return habitRepository.findAll();
    }

    public Habit saveHabit(Habit habit) {
        return habitRepository.save(habit);
    }

    public Habit getHabitById(Long id) {
        return habitRepository.findById(id).orElse(null);
    }

    public void deleteHabit(Long id) {
        habitRepository.deleteById(id);
    }

    public Habit updateHabit(Long id, Habit updatedHabit) {

        Habit habit = habitRepository.findById(id).orElse(null);

        if (habit != null) {
            habit.setName(updatedHabit.getName());
            habit.setDescription(updatedHabit.getDescription());

            return habitRepository.save(habit);
        }

        return null;
    }
}
