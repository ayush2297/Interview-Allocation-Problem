package com.main.interview_allocation.service;

import com.main.interview_allocation.model.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class InterviewScheduler {

    private static int INTERVIEW_DURATION = 2;
    private static LocalTime INTERVIEW_START_TIME = LocalTime.of(9, 0);
    private static LocalTime DAY_END_TIME = LocalTime.of(17, 0);
    private static LocalTime INTERVIEW_END_TIME = INTERVIEW_START_TIME.plusHours(INTERVIEW_DURATION);

    public List<Interview> scheduleInterviews(List<Attendee> attendeeList, List<Interviewer> interviewerList, List<InterviewRoom> roomList) {
        int interviewerNo = 0;
        int roomNo = 0;
        List<Interview> interviews = new ArrayList<>();
        boolean isRoomCountMoreThanInterviewers = roomList.size() > interviewerList.size();
        for (Attendee attendee : attendeeList) {
            if (INTERVIEW_START_TIME.equals(DAY_END_TIME)) {
                System.out.println("pending interviews of id : " + attendee.toString());
                continue;
            }
            Interviewer interviewer = interviewerList.get(interviewerNo++);
            InterviewRoom room = roomList.get(roomNo++);
            InterviewTime time = new InterviewTime(INTERVIEW_START_TIME, INTERVIEW_END_TIME);
            interviewerNo = resetCounterIfAllUsed(interviewerNo, interviewerList.size());
            roomNo = resetCounterIfAllUsed(roomNo, roomList.size());
            if (!isRoomCountMoreThanInterviewers) {
                if (roomNo == 0)
                    updateInterviewTime();
            } else {
                if (interviewerNo == 0)
                    updateInterviewTime();
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

    private void updateInterviewTime() {
        int timeMultiplierFactor = 1;
        LocalTime newTime = INTERVIEW_END_TIME.plusHours(INTERVIEW_DURATION);
        if (newTime.isAfter(LocalTime.of(14, 1)) && newTime.isBefore(LocalTime.of(15,1))) {
            timeMultiplierFactor++;
        }
        INTERVIEW_START_TIME = INTERVIEW_START_TIME.plusHours(INTERVIEW_DURATION * timeMultiplierFactor);
        INTERVIEW_END_TIME = INTERVIEW_END_TIME.plusHours(INTERVIEW_DURATION * timeMultiplierFactor);
    }
}