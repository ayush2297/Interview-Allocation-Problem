package com.test.service;

import com.main.interview_allocation.model.Attendee;
import com.main.interview_allocation.service.InterviewRegistrationService;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class InterviewRegistrationServiceTest {

    List<Attendee> attendees;
    Attendee attendee1;
    Attendee attendee2;
    InterviewRegistrationService interviewRegistrationService;

    @BeforeClass
    public void setUp() {
        attendees = new ArrayList<>();
        attendee1 = new Attendee(1);
        attendee2 = new Attendee(2);
        attendees.add(attendee1);
        attendees.add(attendee2);
    }

    @Test
    public void givenMultipleAttendees_ShouldGetRegistered() {
        interviewRegistrationService.registerAttendees();
    }

}
