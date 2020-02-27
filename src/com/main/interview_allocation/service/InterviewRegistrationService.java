package com.main.interview_allocation.service;

import com.main.interview_allocation.model.Attendee;

import java.util.ArrayList;
import java.util.List;

public class InterviewRegistrationService {

    private InputHelper inputHelper;

    public InterviewRegistrationService() {
        this.inputHelper = new InputHelper();
    }

    public List<Attendee> registerAttendees() {
        System.out.println("Attendees registration");
        List<Attendee> attendeeList = new ArrayList<>();
        while (true) {
            System.out.print("enter the id of attendee :  (press 0 to exit)");
            int newId = inputHelper.readInt();
            if (newId == 0 ) {
                break;
            }
            attendeeList.add(new Attendee(newId));
        }
        return attendeeList;
    }
}
