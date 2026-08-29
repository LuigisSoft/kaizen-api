package com.luigisback.kaizen_api.repository;

import com.luigisback.kaizen_api.entity.HabitLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface HabitLogRepository extends JpaRepository<HabitLog, Long> {
    List<HabitLog> findByHabitIdOrderByDateDesc(Long habitId);

     Long countByHabitId(Long habitId);
     Long countByDate(LocalDate date);

     boolean existsByHabitIdAndDate(Long habitId, LocalDate date);



}
