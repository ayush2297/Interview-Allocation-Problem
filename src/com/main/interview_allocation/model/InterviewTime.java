package com.main.interview_allocation.model;

import java.time.LocalTime;

public class InterviewTime {

    private LocalTime startTime;

    private LocalTime endTime;

    public InterviewTime(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return "\ttime = " + startTime +"="+endTime;
    }
}
