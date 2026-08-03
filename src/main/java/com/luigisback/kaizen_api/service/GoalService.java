package com.luigisback.kaizen_api.service;

import com.luigisback.kaizen_api.entity.Goal;
import com.luigisback.kaizen_api.repository.GoalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalService {

    private final GoalRepository goalRepository;

    public GoalService(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }

    public List<Goal> getAllGoal() {
        return goalRepository.findAll();
    }

    public Goal saveGoal(Goal goal) {
        return goalRepository.save(goal);
    }

    public Goal getGoalbyId(Long id) {
        return goalRepository.findById(id).orElse(null);
    }

    public void deleteGoal(Long id) {
        goalRepository.deleteById(id);
    }

    public Goal updateGoal(Long id, Goal updatedGoal) {

        Goal goal = goalRepository.findById(id).orElse(null);

        if (goal != null) {
            goal.setTitle(updatedGoal.getTitle());
            goal.setDescription(updatedGoal.getDescription());

            return goalRepository.save(goal);
        }

        return null;
    }
}
