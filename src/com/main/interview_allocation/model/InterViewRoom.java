package com.main.interview_allocation.model;

import java.util.Objects;

public class InterviewRoom {

    private String roomName;

    public InterviewRoom(String roomName) {
        this.roomName = roomName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InterviewRoom that = (InterviewRoom) o;
        return Objects.equals(roomName, that.roomName);
    }

    @Override
    public String toString() {
        return "\troom = " +roomName;
    }
}
