package com.main.interview_allocation.service;

import com.main.interview_allocation.model.*;

import java.util.List;
import java.util.Map;

public class InterviewScheduler {
    public Map<Attendee, Interview> scheduleInterviews(List<Attendee> attendeeList, List<Interviewer> interviewerList, List<InterviewRoom> roomList, Map<Attendee, Interview> interviews) {
        int interviewerNo = 0;
        int roomNo = 0;
        for (Attendee attendee : attendeeList) {
            Interviewer interviewer = interviewerList.get(interviewerNo++);
            InterviewRoom interviewRoom = roomList.get(roomNo++);
            if (interviewerNo >= interviewerList.size())
                interviewerNo = 0;
            if (roomNo >= roomList.size())
                roomNo = 0;
            Interview interview = interviews.get(attendee);
            interview.setInterviewer(interviewer);
            interview.setRoom(interviewRoom);
        }
        return interviews;
    }
}