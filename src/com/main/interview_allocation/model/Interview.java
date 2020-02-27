package com.main.interview_allocation.model;

public class Interview {

    private Attendee attendee;

    private Interviewer interviewer;

    private InterviewRoom room;

    private InterviewTime time;

    public Interview(Attendee attendee, Interviewer interviewer, InterviewRoom room, InterviewTime time) {
        this.attendee = attendee;
        this.interviewer = interviewer;
        this.room = room;
        this.time = time;
    }

    @Override
    public String toString() {
        return "\n Interview{" +
                "\n" + attendee +
                "\n" + interviewer +
                "\n" + room +
                "\n" + time +
                "\n}";
    }
}
