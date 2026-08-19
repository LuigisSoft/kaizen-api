package com.luigisback.kaizen_api.service;


import com.luigisback.kaizen_api.entity.Habit;
import com.luigisback.kaizen_api.entity.HabitLog;
import com.luigisback.kaizen_api.repository.HabitLogRepository;
import org.springframework.stereotype.Service;
import com.luigisback.kaizen_api.exception.HabitLogAlreadyExistsException;
import java.util.List;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class HabitLogService {

    private final HabitLogRepository habitLogRepository;

    public HabitLogService(HabitLogRepository habitLogRepository) {
        this.habitLogRepository = habitLogRepository;
    }

    public List<HabitLog> getAllLogs(){return habitLogRepository.findAll();}

    public List<HabitLog>getLogsByHabitId(Long habitId){
        return habitLogRepository.findByHabitId(habitId);

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



    }


