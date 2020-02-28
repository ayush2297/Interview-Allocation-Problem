package com.main.interview_allocation.service;

import com.main.interview_allocation.model.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class InterviewScheduler {

    public List<Interview> scheduleInterviews(List<Attendee> attendeeList, List<Interviewer> interviewerList, List<InterviewRoom> roomList) {
        int interviewDuration = 2;
        LocalTime interviewStartTime = LocalTime.of(9, 0);
        LocalTime interviewEndTime = interviewStartTime.plusHours(interviewDuration);
        LocalTime dayEndTime = LocalTime.of(17, 0);

        int interviewerNo = 0;
        int roomNo = 0;
        List<Interview> interviews = new ArrayList<>();

        boolean isRoomCountMoreThanInterviewers = roomList.size() > interviewerList.size();
        for (Attendee attendee : attendeeList) {
            if (interviewStartTime.equals(dayEndTime)) {
                System.out.println("pending interviews of id : " + attendee.toString());
                continue;
            }
            Interviewer interviewer = interviewerList.get(interviewerNo++);
            InterviewRoom room = roomList.get(roomNo++);
            InterviewTime time = new InterviewTime(interviewStartTime, interviewEndTime);
            interviewerNo = resetCounterIfAllUsed(interviewerNo, interviewerList.size());
            roomNo = resetCounterIfAllUsed(roomNo, roomList.size());
            if (!isRoomCountMoreThanInterviewers) {
                if (roomNo == 0)
                    updateInterviewTime(interviewDuration, interviewStartTime, interviewEndTime);
            } else {
                if (interviewerNo == 0)
                    updateInterviewTime(interviewDuration, interviewStartTime, interviewEndTime);
            }
            interviews.add(new Interview(attendee, interviewer, room, time));
        }
        return interviews;
    }

    private int resetCounterIfAllUsed(int counter, int listSize) {
        if (counter >= listSize) {
            return 0;
        }
        return counter;
    }

    private InterviewTime updateInterviewTime(int interviewDuration, LocalTime interviewStartTime, LocalTime interviewEndTime) {
        int timeMultiplierFactor = 1;
        LocalTime newTime = interviewEndTime.plusHours(interviewDuration);
        if (newTime.isAfter(LocalTime.of(14, 1)) && newTime.isBefore(LocalTime.of(15, 1))) {
            timeMultiplierFactor++;
        }
        interviewStartTime = interviewStartTime.plusHours(interviewDuration * timeMultiplierFactor);
        interviewEndTime = interviewEndTime.plusHours(interviewDuration * timeMultiplierFactor);
        return new InterviewTime(interviewStartTime, interviewEndTime);
    }
}