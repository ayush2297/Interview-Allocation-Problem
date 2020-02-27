package com.main.interview_allocation.model;

import java.util.Objects;

public class Interviewer {

    private String name;

    public Interviewer(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interviewer that = (Interviewer) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public String toString() {
        return "Interviewer{" +
                "name='" + name + '\'' +
                '}';
    }
}
