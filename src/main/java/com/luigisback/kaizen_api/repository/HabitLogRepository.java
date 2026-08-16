package com.luigisback.kaizen_api.repository;

import com.luigisback.kaizen_api.entity.HabitLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HabitLogRepository extends JpaRepository<HabitLog, Long> {
    List<HabitLog> findByHabitId(Long habitId);

     Long countByHabitId(Long habitId);

}
