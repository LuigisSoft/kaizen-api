package com.luigisback.kaizen_api.entity;

public class DashboardResponse {

    private long totalHabits;
    private long completedToday;
    private long totalLogs;

    public long getTotalHabits() {
        return totalHabits;
    }

    public long getCompletedToday() {
        return completedToday;
    }

    public long getTotalLogs() {
        return totalLogs;
    }

    public DashboardResponse(long totalHabits, long completedToday, long totalLogs){
        this.totalHabits=totalHabits;
        this.totalLogs=totalLogs;
        this.completedToday=completedToday;
    }
}
