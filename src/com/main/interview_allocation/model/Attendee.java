package com.main.interview_allocation.model;

public class Attendee {

    private int id;

    public Attendee(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Attendee{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attendee attendee = (Attendee) o;
        return id == attendee.id;
    }
}
