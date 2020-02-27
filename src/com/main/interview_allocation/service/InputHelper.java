package com.main.interview_allocation.service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHelper {
    private Scanner input = new Scanner(System.in);

    public int readInt() {
        while (true) {
            int number = 0;
            try {
                number = input.nextInt();
                this.throwIfLessThan0(number);
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("wrong input.. try again!");
                continue;
            }
            input.nextLine();
            return number;
        }
    }

    public String readInterviewerName() {
        while (true) {
                String name = "";
            try {
                name = input.next();
                if (!name.matches("^[a-zA-Z]$"))
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

    private void throwIfLessThan0(int number) {
        if (number < 0)
            throw new InputMismatchException();
    }
}
