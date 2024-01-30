package examples.messages;

import java.util.ArrayList;
import java.util.List;

public class CheckErrors {
    // Replace with your actual SQL check logic
    public boolean check1() {
        return false;
    }

    // Replace with your actual SQL check logic
    public boolean check2() {
        return true;
    }
    public boolean check3() {
        return true;
    }
    public boolean check4() {
        return true;
    }

    // ... (add more check methods as needed)

    public List<String> checkAllConditions() {
        List<String> errorMessages = new ArrayList<>();

        // Define error messages in a centralized manner
        String[] predefinedErrorMessages = {
                "Error message 1",
                "Error message 2",
                "Error message 3",
                "Error message 4",
                // ... (add more error messages as needed)
        };

        // Check conditions and add corresponding error messages
        for (int i = 0; i < predefinedErrorMessages.length; i++) {
            if (checkCondition(i + 1)) {
                errorMessages.add(predefinedErrorMessages[i]);
            }
        }

        return errorMessages;
    }

    // Example: A generic check method based on a condition index
    private boolean checkCondition(int conditionIndex) {
        switch (conditionIndex) {
            case 1:
                return check1();
            case 2:
                return check2();
            case 3:
                return check3();
            case 4:
                return check4();
            // ... (add more cases for other conditions)
            default:
                throw new IllegalArgumentException("Invalid condition index");
        }
    }

    public static void main(String[] args) {
        CheckErrors checkDao = new CheckErrors();

        // Example: Check all conditions
        List<String> allErrorMessages = checkDao.checkAllConditions();

        // Combine error messages if needed
        // \n : a newline
        String combinedErrorMessage = String.join("\n", allErrorMessages);
        String finalMessage = combinedErrorMessage.isEmpty() ? "No Errors" : combinedErrorMessage;
        System.out.println("main:::");
        System.out.println(finalMessage);
    }
}
