package com.main.interview_allocation.service;

import com.main.interview_allocation.model.Attendee;
import com.main.interview_allocation.model.Interview;
import com.main.interview_allocation.model.InterviewRoom;
import com.main.interview_allocation.model.Interviewer;

import java.util.List;

public class InterviewManagementDashboard {

    private InterviewRegistrationService registrationService;
    private InterviewScheduler scheduler;

    public InterviewManagementDashboard() {
        registrationService = new InterviewRegistrationService();
        scheduler = new InterviewScheduler();
    }

    public void display() {
        List<Attendee> attendeesList = registrationService.registerAttendees();
        List<Interviewer> interviewersList = registrationService.registerInterviewers();
        List<InterviewRoom> roomsList = registrationService.registerRooms();
        List<Interview> interviews = scheduler.scheduleInterviews(attendeesList, interviewersList, roomsList);
        System.out.println(interviews.toString());
    }
}
