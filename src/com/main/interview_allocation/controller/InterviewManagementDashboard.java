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
        LocalTime startTime = LocalTime.of(9, 0);
        LocalTime endTime = LocalTime.of(17, 0);
        LocalTime breakStartTime = LocalTime.of(14, 0);
        LocalTime breakEndTime = LocalTime.of(15, 0);
        int interviewDuration = 1;
        inputHandler = new InputHandler();
        scheduler = new InterviewScheduler(new TimeSlotManager(startTime,endTime,breakStartTime,breakEndTime,interviewDuration));
    }

    public void display() {
        List<Attendee> attendeesList = getAttendees();
        setInterviewCount(attendeesList);
        List<Interviewer> interviewersList = getInterviewers();
        List<InterviewRoom> roomsList = getRooms();
        List<Interview> interviews = scheduler.scheduleInterviews(attendeesList, interviewersList, roomsList);
        System.out.println(interviews.toString());
    }

    private List<Attendee> getAttendees() {
        System.out.println("Attendees registration (Format : <id/non-negative-number>)");
        return inputHandler.getList(ATTENDEE_ID_FORMAT).stream().map(Attendee::new).collect(Collectors.toList());
    }

    private List<Interviewer> getInterviewers() {
        System.out.println("Interviewer registration (Format : <name>");
        return inputHandler.getList(INTERVIEWER_ID_FORMAT).stream().map(Interviewer::new).collect(Collectors.toList());
    }

    private List<InterviewRoom> getRooms() {
        System.out.println("Room registration (Format : R<room-no>)");
        return inputHandler.getList(ROOM_ID_FORMAT).stream().map(InterviewRoom::new).collect(Collectors.toList());
    }

    private void setInterviewCount(List<Attendee> attendeesList) {
        System.out.println("enter no of interviews for each attendee");
        attendeesList.forEach(attendee -> attendee.setNoOfInterviews(Integer.parseInt(inputHandler.getInput(NUMBER_FORMAT))));
    }

}
