package com.luigisback.kaizen_api.repository;

import com.luigisback.kaizen_api.entity.HabitLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitLogRepository extends JpaRepository<HabitLog, Long> {
}
