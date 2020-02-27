package com.main.interview_allocation.model;

public class Interview {

    private Attendee attendee;

    private Interviewer interviewer;

    private InterviewRoom room;

    public Interview(Attendee attendee) {
        this.attendee = attendee;
    }

    public void setInterviewer(Interviewer interviewer) {
        this.interviewer = interviewer;
    }

    public void setRoom(InterviewRoom room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "\nInterview{" +
                "\n\tattendee=" + attendee +
                ",\n\tinterviewer=" + interviewer +
                ",\n\troom=" + room +
                "\n}";
    }
}
