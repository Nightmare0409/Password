import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
        // Creating a scanner object to read user input.
        try (Scanner sc = new Scanner(System.in)) {
            // Assuming the password is valid initially.
            boolean valid = true;

            // Prompting the user to enter a password.
            System.out.print("Please enter a password: ");
            String password = sc.nextLine();

            // Checking password length.
            if (password.length() < 8 || password.length() > 16) {
                // If the password length is not within the required range, invalidate the password
                valid = false;
                System.out.println("Password must be between 8 and 16 characters.");
            }

            // Checking if the password contains at least three out of four required categories.
            boolean hasLowerCase = false;
            boolean hasUpperCase = false;
            boolean hasDigit = false;
            boolean hasSpecialSymbol = false;

            // Iteratating through each character of the password to determine its categories.
            for (char ch : password.toCharArray()) {
                if (Character.isLowerCase(ch)) {
                    // Checking if the character is a lowercase letter.
                    hasLowerCase = true;
                } else if (Character.isUpperCase(ch)) {
                    // Checking if the character is an uppercase letter.
                    hasUpperCase = true;
                } else if (Character.isDigit(ch)) {
                    // Checking if the character is a digit.
                    hasDigit = true;
                } else if ("~!@#$%^&*()-=+_".indexOf(ch) >= 0) {
                    // Checking if the character is a special symbol.
                    hasSpecialSymbol = true;
                }
            }

            // Counting the number of distinct categories present in the password
            int categoryCount = 0;
            if (hasLowerCase) categoryCount++;
            if (hasUpperCase) categoryCount++;
            if (hasDigit) categoryCount++;
            if (hasSpecialSymbol) categoryCount++;

            // Invalidates the password if at least 3 requirements aren't met.
            if (categoryCount < 3) {
                valid = false;
                System.out.println("Password must include at least three of the following categories:");
                System.out.println("1. Lowercase letters (a-z)");
                System.out.println("2. Uppercase letters (A-Z)");
                System.out.println("3. Digits (0-9)");
                System.out.println("4. Special symbols (~!@#$%^&*()-=+_)");
            }

            // Printing whether the password is accepted or rejected.
            if (valid) {
                System.out.println("Password accepted!");
            } else {
                System.out.println("Password does not meet the requirements.");
            }
        }
    }
}

