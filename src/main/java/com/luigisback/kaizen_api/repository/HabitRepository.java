package com.luigisback.kaizen_api.repository;

import com.luigisback.kaizen_api.entity.Habit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitRepository extends JpaRepository<Habit, Long>{
}
