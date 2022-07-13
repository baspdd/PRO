
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class Input {

    static Scanner sc = new Scanner(System.in);

    static int getInt(String message, int min, int max) {
        //loop until user input a valid value
        while (true) {
            System.out.print(message);
            try {
                String input = sc.nextLine();
                //check if input is empty or not
                if (input.isEmpty()) {
                    System.out.println("Input cannot be empty!");
                } else {
                    int inputInt = Integer.parseInt(input);
                    //check if inputted value is in range or not
                    if (min <= inputInt && inputInt <= max) {
                        return inputInt;
                    } else {
                        System.out.println("Input must be in range " + min + " to " + max);
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Input a number!");
            }
        }
    }

    static String getString(String message, String regex) {
        //loop until user input a valid string
        while (true) {
            System.out.print(message);
            String input = sc.nextLine();
            //check if input string is empty or not
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty!");
            } else {
                //check if the input string is valid or not
                if (input.matches(regex)) {
                    return input;
                } else {
                    System.out.println("Invalid!");
                }
            }
        }
    }

    static double getDouble() {
        //loop until user input a valid salary
        while (true) {
            System.out.print("Time: ");
            String input = sc.nextLine();
            //check if input is empty or not
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty!");
            } else {
                try {
                    double time = Double.parseDouble(input);
                    //check if salary is under or equal 0 or not
                    if (time > 0 && time < 24) {
                        return time;
                    } else {
                        System.out.print("Salary must more than 0!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Salary must be a numberical value!");
                }
            }
        }
    }

    static String getString(String message, List<String> VALID_TYPES) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine();
            //check if input string is empty or not
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty!");
            } else {
                //check if the input string is valid or not
                for (String check : VALID_TYPES) {
                    if (check.equalsIgnoreCase(input)) {
                        return input;
                    }
                }
                System.out.println("Invalid!");
            }
        }
    }
}
