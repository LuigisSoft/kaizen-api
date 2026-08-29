package com.luigisback.kaizen_api.controller;

import com.luigisback.kaizen_api.entity.DashboardResponse;
import com.luigisback.kaizen_api.service.DashboardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/api/dashboard")
    public DashboardResponse getDashboard() {

        return new DashboardResponse(
                dashboardService.getTotalHabits(),
                dashboardService.getCompletedToday(),
                dashboardService.getTotalLogs()
        );
    }
}