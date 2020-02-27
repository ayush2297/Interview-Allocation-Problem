package com.main.interview_allocation.service;

import com.main.interview_allocation.model.Attendee;
import com.main.interview_allocation.model.InterviewRoom;
import com.main.interview_allocation.model.Interviewer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.main.interview_allocation.service.InputHelper.EXIT_TEXT;

public class InterviewRegistrationService {
    private static final String ATTENDEE_ID_FORMAT = "^[1-9][0-1]*$";
    private static final String INTERVIEWER_ID_FORMAT = "^[a-zA-Z]+$";
    private static final String ROOM_ID_FORMAT = "^[R][0-9]+$";
    private InputHelper inputHelper;

    public InterviewRegistrationService() {
        this.inputHelper = new InputHelper();
    }

    public List<Attendee> registerAttendees() {
        System.out.println("Attendees registration");
        return getList(ATTENDEE_ID_FORMAT).stream().map(Attendee::new).collect(Collectors.toList());
    }

    public List<Interviewer> registerInterviewers() {
        System.out.println("Interviewer registration");
        return getList(INTERVIEWER_ID_FORMAT).stream().map(Interviewer::new).collect(Collectors.toList());
    }

    public List<InterviewRoom> registerRooms() {
        System.out.println("Room registration");
        return getList(ROOM_ID_FORMAT).stream().map(InterviewRoom::new).collect(Collectors.toList());
    }

    private List<String> getList(String inputFormat) {
        List<String> inputs = new ArrayList<>();
        while (true) {
            System.out.print("enter the id :  (type 'done' to exit)");
            String newAttendee = inputHelper.inputReader(inputFormat);
            if (newAttendee.equals(EXIT_TEXT)) {
                break;
            }
            if (inputs.contains(newAttendee)) {
                System.out.println("already registered...!!");
                continue;
            }
            inputs.add(newAttendee);
        }
        return inputs;
    }
}
