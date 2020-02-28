package com.main.interview_allocation.controller;

import com.main.interview_allocation.model.Attendee;
import com.main.interview_allocation.model.Interview;
import com.main.interview_allocation.model.InterviewRoom;
import com.main.interview_allocation.model.Interviewer;
import com.main.interview_allocation.service.InterviewScheduler;
import com.main.interview_allocation.service.TimeSlotManager;
import com.main.interview_allocation.utilities.InputHandler;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

public class InterviewManagementDashboard {

    private InputHandler inputHandler;
    private InterviewScheduler scheduler;
    private static final String ATTENDEE_ID_FORMAT = "^[1-9][0-1]*$";
    private static final String NUMBER_FORMAT = "^[1-9]+$";
    private static final String INTERVIEWER_ID_FORMAT = "^[a-zA-Z]+$";
    private static final String ROOM_ID_FORMAT = "^[R][0-9]+$";

    public InterviewManagementDashboard() {
        inputHandler = new InputHandler();
        scheduler = new InterviewScheduler(new TimeSlotManager(LocalTime.of(9, 0),LocalTime.of(17, 0),2));
    }

    public void display() {
        List<Attendee> attendeesList = registerAttendees();
        attendeesList = setInterviewCount(attendeesList);
        List<Interviewer> interviewersList = registerInterviewers();
        List<InterviewRoom> roomsList = registerRooms();
        List<Interview> interviews = scheduler.scheduleInterviews(attendeesList, interviewersList, roomsList);
        System.out.println(interviews.toString());
    }

    private List<Attendee> setInterviewCount(List<Attendee> attendeesList) {
        System.out.println("enter no of interviews for each attendee");
        attendeesList.forEach(attendee -> attendee.setNoOfInterviews(Integer.parseInt(inputHandler.getInput(NUMBER_FORMAT))));
        return attendeesList;
    }

    private List<Attendee> registerAttendees() {
        System.out.println("Attendees registration (Format : <id/non-negative-number>)");
        return inputHandler.getList(ATTENDEE_ID_FORMAT).stream().map(Attendee::new).collect(Collectors.toList());
    }

    private List<Interviewer> registerInterviewers() {
        System.out.println("Interviewer registration (Format : <name>");
        return inputHandler.getList(INTERVIEWER_ID_FORMAT).stream().map(Interviewer::new).collect(Collectors.toList());
    }

    private List<InterviewRoom> registerRooms() {
        System.out.println("Room registration (Format : R<room-no>)");
        return inputHandler.getList(ROOM_ID_FORMAT).stream().map(InterviewRoom::new).collect(Collectors.toList());
    }

}
