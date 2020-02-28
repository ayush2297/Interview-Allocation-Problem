package com.main.interview_allocation.utilities;

import java.util.ArrayList;
import java.util.List;

import static com.main.interview_allocation.utilities.InputHelper.EXIT_TEXT;

public class InputUtility {

    private InputHelper inputHelper;

    public InputUtility() {
        this.inputHelper = new InputHelper();
    }

    public List<String> getList(String inputFormat) {
        List<String> inputs = new ArrayList<>();
        while (true) {
            System.out.print("enter the id :  (type 'done' to exit)");
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
}
