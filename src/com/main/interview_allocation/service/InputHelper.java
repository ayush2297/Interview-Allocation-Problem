package com.main.interview_allocation.service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHelper {
    public static final String EXIT_TEXT = "done";
    private Scanner input = new Scanner(System.in);

    public String inputReader(String regex) {
        while (true) {
            String name;
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
