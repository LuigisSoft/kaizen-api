package com.luigisback.kaizen_api.controller;

import com.luigisback.kaizen_api.entity.Goal;
import com.luigisback.kaizen_api.service.GoalService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import jakarta.validation.Valid;

import java.util.List;


@RestController
public class GoalController {

    private final GoalService goalService;

    public GoalController(GoalService goalService){

        this.goalService = goalService;
    }

    @GetMapping("/api/goals")
    public List<Goal>getAllGoals(){

        return goalService.getAllGoal();
    }
    @PostMapping ("/api/goals")
    public Goal createGoal(@Valid @RequestBody Goal goal){
        return goalService.saveGoal(goal);
    }



    @GetMapping("/api/goals/{id}")
    public Goal getGoalById(@PathVariable Long id){
        return goalService.getGoalbyId(id);

    }


    @DeleteMapping("/api/goals/{id}")
    public void deleteGoals(@PathVariable Long id){
        goalService.deleteGoal(id);
    }

    @PutMapping("/api/goals/{id}")
    public Goal updateGoal(@PathVariable Long id,
                           @RequestBody Goal goal){
        return goalService.updateGoal(id, goal);
    }


}
