package asm1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Customer {

    private final int phone;
    private final String name;

    private Customer(int phone, String name) {
        this.phone = phone;
        this.name = name;
    }

    public int getPhone() {
        return this.phone;
    }

    public String toString() {
        return String.format("%s; %s", this.name, this.phone);
    }

    public static List<Customer> load(String file) {
        List<Customer> customerList = new LinkedList<>();
        try {
            new File(file).createNewFile();
        }
        catch (IOException e) {}
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    String[] args = line.trim().split("; ");
                    int phone = Integer.parseInt(args[1]);
                    String name = args[0];
                    if (phone < 8000000 || phone > 8999999) continue;
                    if (name.length() > 25) continue;
                    customerList.add(new Customer(phone, name));
                }
                catch (RuntimeException e) {}
            }
        }
        catch (IOException e) {}
        return customerList;
    }
}
