package com.main.interview_allocation.service;

import com.main.interview_allocation.model.Attendee;
import com.main.interview_allocation.model.InterViewRoom;
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
            System.out.print("enter the id of attendee :  (type 'done' to exit)");
            String newAttendee = inputHelper.readAttendeeId();
            if (newAttendee == EXIT_TEXT) {
                break;
            }
            Attendee attendee = new Attendee(newAttendee);
            if (!idAlreadyRegistered(attendeesList, attendee))
                attendeesList.add(attendee);
        }
        return attendeesList;
    }

    public List<Interviewer> registerInterviewers() {
        System.out.println("Interviewer registration");
        List<Interviewer> interviewersList = new ArrayList<>();
        while (true) {
            System.out.print("enter the id of interviewer :  (type 'done' to exit)");
            String newInterviewer = inputHelper.readInterviewerName();
            if (newInterviewer == EXIT_TEXT) {
                break;
            }
            Interviewer interviewer = new Interviewer(newInterviewer);
            if (!idAlreadyRegistered(interviewersList, interviewer))
                interviewersList.add(interviewer);
        }
        return interviewersList;
    }

    public List<InterViewRoom> registerRooms() {
        System.out.println("Room registration");
        List<InterViewRoom> roomList = new ArrayList<>();
        while (true) {
            System.out.print("enter the id of room :  (type 'done' to exit)");
            String newRoom = inputHelper.readRoomId();
            if (newRoom == EXIT_TEXT) {
                break;
            }
            InterViewRoom interviewRoom = new InterViewRoom(newRoom);
            if (!this.idAlreadyRegistered(roomList, interviewRoom))
                roomList.add(interviewRoom);
        }
        return roomList;
    }

    private <E> boolean idAlreadyRegistered(List<E> list, Object object) {
        if (list.contains(object)) {
            System.out.println("already registered...!!");
            return true;
        }
        return false;
    }
}
