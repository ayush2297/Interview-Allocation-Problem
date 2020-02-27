package com.main.interview_allocation.service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHelper {
    private static final String ATTENDEE_ID_FORMAT = "^[1-9][0-1]*$";
    private static final String INTERVIEWER_ID_FORMAT = "^[a-zA-Z]+$";
    public static final String EXIT_TEXT = "exit";
    private Scanner input = new Scanner(System.in);

    public String readAttendeeId() {
        return inputReader(ATTENDEE_ID_FORMAT);
    }

    public String readInterviewerName() {
        return inputReader(INTERVIEWER_ID_FORMAT);
    }

    public String inputReader(String regex) {
        while (true) {
            String name = "";
            try {
                name = input.next();
                if (name.toLowerCase().matches(EXIT_TEXT))
                    return EXIT_TEXT;
                if (!name.matches(regex))
                    throw new InputMismatchException();
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("wrong input.. try again!");
                continue;
            }
            input.nextLine();
            return name;
        }
    }

}
