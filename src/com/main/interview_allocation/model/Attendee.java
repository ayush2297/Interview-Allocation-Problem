package com.main.interview_allocation.model;

public class Attendee {

    private String id;

    private int noOfInterviews;

    public Attendee(String id) {
        this.id = id;
    }

    public int getNoOfInterviews() {
        return noOfInterviews;
    }

    public void setNoOfInterviews(int noOfInterviews) {
        this.noOfInterviews = noOfInterviews;
    }

    @Override
    public String toString() {
        return "\tAttendee = " + id + " pending interviews : " + noOfInterviews;
    }
}
