package com.main.interview_allocation.model;

import java.util.Objects;

public class InterViewRoom {
    private String roomName;

    public InterViewRoom(String roomName) {
        this.roomName = roomName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InterViewRoom that = (InterViewRoom) o;
        return Objects.equals(roomName, that.roomName);
    }
}
