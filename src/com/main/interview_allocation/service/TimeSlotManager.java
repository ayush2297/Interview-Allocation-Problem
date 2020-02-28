package com.main.interview_allocation.service;

import com.main.interview_allocation.model.InterviewTime;

import java.time.LocalTime;

public class TimeSlotManager {
    private LocalTime slotStartsAt;
    private final LocalTime dayEndsAt;
    private int interviewDuration;

    public TimeSlotManager(LocalTime slotStartsAt, LocalTime dayEndsAt, int interviewDuration) {
        this.slotStartsAt = slotStartsAt;
        this.dayEndsAt = dayEndsAt;
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
        if (newStartTime.isAfter(LocalTime.of(13, 59)) && newStartTime.isBefore(LocalTime.of(15, 0))
                || newEndTime.isAfter(LocalTime.of(14, 0)) && newEndTime.isBefore(LocalTime.of(15, 1))) {
            newStartTime = newStartTime.plusHours(interviewDuration);
            newEndTime = newEndTime.plusHours(interviewDuration);
        }
        return new InterviewTime(newStartTime,newEndTime);
    }

    private boolean isOverlappingBreakTime(LocalTime time) {
        return time.isAfter(LocalTime.of(13, 59)) && time.isBefore(LocalTime.of(15, 1));
    }
}
