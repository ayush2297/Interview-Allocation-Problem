package com.main.interview_allocation.model;

import java.time.LocalDateTime;

public class InterviewTime {

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    public InterviewTime(LocalDateTime startTime, LocalDateTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "InterviewTime{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
