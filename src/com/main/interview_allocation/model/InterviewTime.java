package com.main.interview_allocation.model;

import java.time.LocalTime;

public class InterviewTime {

    private final LocalTime startTime;

    private final LocalTime endTime;

    public InterviewTime(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "\ttime = " + startTime +"="+endTime;
    }
}
