package com.main.interview_allocation.service;

import com.main.interview_allocation.model.Attendee;

import java.util.List;

public class InterviewManagementDashboard {

    private InterviewRegistrationService registrationService;

    public InterviewManagementDashboard() {
        registrationService = new InterviewRegistrationService();
    }

    public void display() {
        List<Attendee> attendeeList = registrationService.registerAttendees();
        System.out.println(attendeeList.toString());
    }
}
