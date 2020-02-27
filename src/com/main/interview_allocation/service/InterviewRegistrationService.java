package com.main.interview_allocation.service;

import com.main.interview_allocation.model.Attendee;
import com.main.interview_allocation.model.Interviewer;

import java.util.ArrayList;
import java.util.List;

import static com.main.interview_allocation.service.InputHelper.EXIT_TEXT;

public class InterviewRegistrationService {

    private InputHelper inputHelper;

    public InterviewRegistrationService() {
        this.inputHelper = new InputHelper();
    }

    public List<Attendee> registerAttendees() {
        System.out.println("Attendees registration");
        List<Attendee> attendeesList = new ArrayList<>();
        while (true) {
            System.out.print("enter the id of attendee :  (type 'exit' to exit)");
            String newAttendee = inputHelper.readInt();
            if (newAttendee == EXIT_TEXT) {
                break;
            }
            Attendee attendee = new Attendee(newAttendee);
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
            if (newInterviewer == EXIT_TEXT) {
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
