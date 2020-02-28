package com.main.interview_allocation.service;

import com.main.interview_allocation.model.*;

import java.util.ArrayList;
import java.util.List;

public class InterviewScheduler {

    private TimeSlotManager timeSlotManager;

    public InterviewScheduler(TimeSlotManager timeSlotManager) {
        this.timeSlotManager = timeSlotManager;
    }

    public List<Interview> scheduleInterviews(List<Attendee> attendeeList, List<Interviewer> interviewerList, List<InterviewRoom> roomList) {
        int interviewerNo = 0;
        int roomNo = 0;
        List<Interview> interviews = new ArrayList<>();
        InterviewTime interviewSlot = timeSlotManager.getSlot();
        boolean isRoomCountMoreThanInterviewers = roomList.size() > interviewerList.size();
        for (Attendee attendee : attendeeList) {
            if (interviewSlot.getStartTime().isAfter(timeSlotManager.getDayEndsAt().minusMinutes(1))) {
                System.out.println("pending interviews of id : " + attendee.toString());
                continue;
            }
            Interviewer interviewer = interviewerList.get(interviewerNo++);
            InterviewRoom room = roomList.get(roomNo++);
            interviewerNo = resetCounterIfAllUsed(interviewerNo, interviewerList.size());
            roomNo = resetCounterIfAllUsed(roomNo, roomList.size());
            interviews.add(new Interview(attendee, interviewer, room, interviewSlot));
            interviewSlot = getInterviewTime(interviewerNo, roomNo, interviewSlot, isRoomCountMoreThanInterviewers);
        }
        return interviews;
    }

    private InterviewTime getInterviewTime(int interviewerNo, int roomNo, InterviewTime interviewSlot, boolean isRoomCountMoreThanInterviewers) {
        if (!isRoomCountMoreThanInterviewers) {
            if (roomNo == 0)
                interviewSlot = timeSlotManager.updateInterviewTime(interviewSlot);
        } else if (isRoomCountMoreThanInterviewers){
            if (interviewerNo == 0)
                interviewSlot = timeSlotManager.updateInterviewTime(interviewSlot);
        } else {
            if (roomNo==0)
                interviewSlot = timeSlotManager.updateInterviewTime(interviewSlot);
        }
        return interviewSlot;
    }

    private int resetCounterIfAllUsed(int counter, int listSize) {
        if (counter >= listSize) {
            return 0;
        }
        return counter;
    }

}