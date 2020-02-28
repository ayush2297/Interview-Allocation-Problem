package com.main.interview_allocation.service;

import com.main.interview_allocation.model.InterviewTime;

import java.time.LocalTime;

public class TimeSlotManager {
    private LocalTime slotStartsAt;
    private final LocalTime dayEndsAt;
    private final LocalTime breakStartTime;
    private final LocalTime breakEndTime;
    private int interviewDuration;

    public TimeSlotManager(LocalTime slotStartsAt, LocalTime dayEndsAt, LocalTime breakStartTime, LocalTime breakEndTime, int interviewDuration) {
        this.slotStartsAt = slotStartsAt;
        this.dayEndsAt = dayEndsAt;
        this.breakStartTime = breakStartTime;
        this.breakEndTime = breakEndTime;
        this.interviewDuration = interviewDuration;
    }

    public LocalTime getDayEndsAt() {
        return dayEndsAt;
    }

    public InterviewTime getSlot() {
        return new InterviewTime(slotStartsAt, getEndTime(slotStartsAt));
    }

    private LocalTime getEndTime(LocalTime slotStartsAt) {
        return slotStartsAt.plusHours(interviewDuration);
    }

    public InterviewTime updateInterviewTime(InterviewTime interviewSlot) {
        LocalTime newStartTime = interviewSlot.getEndTime();
        LocalTime newEndTime = getEndTime(newStartTime);
        if (newStartTime.isAfter(breakStartTime.minusMinutes(1)) && newStartTime.isBefore(breakEndTime)
                || newEndTime.isAfter(breakStartTime) && newEndTime.isBefore(breakEndTime.plusMinutes(1))) {
            newStartTime = breakEndTime;
            newEndTime = getEndTime(newStartTime);
        }
        if (newStartTime.isAfter(dayEndsAt.minusMinutes(1)) || newEndTime.isAfter(dayEndsAt.minusMinutes(1)) )
            return new InterviewTime(dayEndsAt,dayEndsAt);
        return new InterviewTime(newStartTime, newEndTime);
    }
}
