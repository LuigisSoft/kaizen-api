package com.luigisback.kaizen_api.service;

import org.springframework.stereotype.Service;
import com.luigisback.kaizen_api.repository.HabitRepository;
import com.luigisback.kaizen_api.repository.HabitLogRepository;

import java.time.LocalDate;


@Service
public class DashboardService {
    private final HabitRepository habitRepository;
    private final HabitLogRepository habitLogRepository;


    public DashboardService(HabitRepository habitRepository, HabitLogRepository habitLogRepository) {
        this.habitRepository = habitRepository;
        this.habitLogRepository = habitLogRepository;


        }

    public long getTotalHabits() {
        return habitRepository.count();
    }

   public long getTotalLogs() {
        return habitLogRepository.count();
    }

    public long getCompletedToday() {
        return habitLogRepository.countByDate(LocalDate.now());
    }
}
