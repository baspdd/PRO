
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class Customer {

    public static final String NAME_VALID = "[a-zA-Z ]{1,25}";

    private String name;
    private int phone;

    public Customer() {
    }

    public Customer(String name, int phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("%s; %s", name, phone);
    }

    public static List<Customer> setCusData(String CustomerFile) {
        List<Customer> CustomerList = new LinkedList<>();
        try {
            new File(CustomerFile).createNewFile();
        } catch (IOException e) {
        }
        try (BufferedReader inp = new BufferedReader(new FileReader(CustomerFile))) {
            String line;
            while ((line = inp.readLine()) != null) {
                try {
                    String[] args = line.trim().split("; ");
                    String name = args[0];
                    int phone = Integer.parseInt(args[1]);
                    if (phone < 8000000 || phone > 8999999 && !name.matches(NAME_VALID)) {
                        continue;
                    }
                    CustomerList.add(new Customer(name, phone));
                } catch (RuntimeException e) {
                }
            }
        } catch (IOException e) {
        }
        return CustomerList;
    }

}
