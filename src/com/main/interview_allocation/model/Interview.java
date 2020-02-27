package com.main.interview_allocation.model;

public class Interview {

    private Attendee attendee;

    private Interviewer interviewer;

    private InterviewRoom room;

    public Interview(Attendee attendee, Interviewer interviewer, InterviewRoom room) {
        this.attendee = attendee;
        this.interviewer = interviewer;
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
