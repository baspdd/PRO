/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Main {

    private static void displayMenu() {
        System.out.println("\n-------MAIN MENU-------");
        System.out.println("\t1. Add customer");
        System.out.println("\t2. Update phonecall");
        System.out.println("\t3. View ");
        System.out.println("\t4. Exit \n");
    }

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = Input.getInt("Your choice: ", 1, 4);
            switch (choice) {
                case 1:
                    Management.insertCus("customer.dat");

                    break;
                case 2:
                    Management.insertData("phone.dat");
                    break;
                case 3:
                    Management.save(Management.load("customer.dat", "phone.dat"), "result.dat");
                    return;
                case 4:
                    return;
            }
        }

    }
}
