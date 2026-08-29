package com.luigisback.kaizen_api.service;


import com.luigisback.kaizen_api.entity.Habit;
import com.luigisback.kaizen_api.entity.HabitLog;
import com.luigisback.kaizen_api.exception.HabitNotFoundException;
import com.luigisback.kaizen_api.repository.HabitLogRepository;
import com.luigisback.kaizen_api.repository.HabitRepository;
import org.springframework.stereotype.Service;
import com.luigisback.kaizen_api.exception.HabitLogAlreadyExistsException;

import java.time.LocalDate;
import java.util.List;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class HabitLogService {

    private final HabitRepository habitRepository;
    private final HabitLogRepository habitLogRepository;

    public HabitLogService(HabitLogRepository habitLogRepository,
                           HabitRepository habitRepository) {
        this.habitLogRepository = habitLogRepository;
        this.habitRepository = habitRepository;
    }

    public List<HabitLog> getAllLogs(){return habitLogRepository.findAll();}

    public List<HabitLog>getLogsByHabitId(Long habitId){
        return habitLogRepository.findByHabitIdOrderByDateDesc(habitId);

    }
    public long countLogsByHabitId(Long habitId){
        return habitLogRepository.countByHabitId(habitId);
    }



    public HabitLog saveHabitLogs(HabitLog habitLog){

        if(habitLogRepository.existsByHabitIdAndDate(
                habitLog.getHabit().getId(),
                habitLog.getDate())){

            throw new HabitLogAlreadyExistsException("El hábito ya esta registrado para este día");

        }


        return habitLogRepository.save(habitLog);}

    public HabitLog getHabitLogById(Long id){
        return habitLogRepository.findById(id).orElse(null);    }

    public void deleteHabitLog(Long id){habitLogRepository.deleteById(id);}

    public long getCurrentStreak(Long habitId){

        // Comprobamos primero que el hábito existe
        habitRepository.findById(habitId)
                .orElseThrow(() ->
                        new HabitNotFoundException("Hábito no encontrado"));

        List<HabitLog> logs= habitLogRepository.findByHabitIdOrderByDateDesc(habitId);



        if(logs.isEmpty()){
            return  0;
        }

        LocalDate lastDate = logs.get(0).getDate();
        LocalDate today = LocalDate.now();

        if (lastDate.isBefore(today.minusDays(1))) {
            return 0;
        }

        long streak =1;

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


