package com.main.interview_allocation.service;

import com.main.interview_allocation.model.Attendee;
import com.main.interview_allocation.model.Interviewer;

import java.util.List;

public class InterviewManagementDashboard {

    private InterviewRegistrationService registrationService;

    public InterviewManagementDashboard() {
        registrationService = new InterviewRegistrationService();
    }

    public void display() {
        List<Attendee> attendeesList = registrationService.registerAttendees();
        List<Interviewer> interviewersList = registrationService.registerInterviewers();
        interviewersList.toString();
    }
}
