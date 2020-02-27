package com.main.interview_allocation.service;

import com.main.interview_allocation.model.Attendee;
import com.main.interview_allocation.model.Interviewer;

import java.util.ArrayList;
import java.util.List;

public class InterviewRegistrationService {

    private InputHelper inputHelper;

    public InterviewRegistrationService() {
        this.inputHelper = new InputHelper();
    }

    public List<Attendee> registerAttendees() {
        System.out.println("Attendees registration");
        List<Attendee> attendeesList = new ArrayList<>();
        while (true) {
            System.out.print("enter the id of attendee :  (press 0 to exit)");
            int newId = inputHelper.readInt();
            if (newId == 0) {
                break;
            }
            Attendee attendee = new Attendee(newId);
            if (attendeesList.contains(attendee)) {
                System.out.println("attendee already registered...!!");
                continue;
            }
            attendeesList.add(attendee);
        }
        return attendeesList;
    }

    public List<Interviewer> registerInterviewers() {
        System.out.println("Interviewer registration");
        List<Interviewer> attendeesList = new ArrayList<>();
        while (true) {
            System.out.print("enter the id of interviewer :  (type 'exit' to exit)");
            String newInterviewer = inputHelper.readInterviewerName();
            if (newInterviewer == "exit") {
                break;
            }
            Interviewer interviewer = new Interviewer(newInterviewer);
            if (attendeesList.contains(interviewer)) {
                System.out.println("interviewer already registered...!!");
                continue;
            }
            attendeesList.add(interviewer);
        }
        return attendeesList;
    }
}
