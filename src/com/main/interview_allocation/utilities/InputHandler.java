package com.main.interview_allocation.utilities;

import java.util.ArrayList;
import java.util.List;

import static com.main.interview_allocation.utilities.InputHelper.EXIT_TEXT;

public class InputHandler {

    private InputHelper inputHelper;

    public InputHandler() {
        this.inputHelper = new InputHelper();
    }

    public List<String> getList(String inputFormat) {
        List<String> inputs = new ArrayList<>();
        while (true) {
            System.out.print("enter data :  (type 'done' to exit)");
            String newAttendee = inputHelper.inputReader(inputFormat);
            if (newAttendee.equals(EXIT_TEXT)) {
                break;
            }
            if (inputs.contains(newAttendee)) {
                System.out.println("already registered...!!");
                continue;
            }
            inputs.add(newAttendee);
        }
        return inputs;
    }

    public String getInput(String regex) {
        return inputHelper.inputReader(regex);
    }
}
