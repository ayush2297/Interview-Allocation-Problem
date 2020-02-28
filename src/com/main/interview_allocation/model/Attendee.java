package com.main.interview_allocation.model;

import java.util.Objects;

public class Attendee {

    private String id;

    public Attendee(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attendee attendee = (Attendee) o;
        return Objects.equals(id, attendee.id);
    }

    @Override
    public String toString() {
        return "\tAttendee ="+ id ;
    }
}
