/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Management implements Comparable<Management> {

    private int phone;
    private Customer customer;
    private List<DataStorage> callList;

    private class type {

        final String[] name = (String[]) DataStorage.VALID_TYPES.toArray();
        int[] frequence = new int[4];

        public type() {
            for (int i = 0; i < 4; i++) {
                frequence[i] = 0;
            }
        }
    }

    private Management(Customer customer) {
        this.phone = customer.getPhone();
        this.customer = customer;
        this.callList = new LinkedList<>();

    }

    private Management(int phone) {
        this.phone = phone;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public List<DataStorage> getCallList() {
        return this.callList;
    }

    public void addCall(DataStorage call) {
        this.callList.add(call);
    }

    @Override
    public int compareTo(Management other) {
        return Integer.compare(this.phone, other.phone);
    }

    @Override
    public String toString() {
        return "Management{" + "phone=" + phone + ", customer=" + customer + ", callList=" + callList + '}';
    }

    public static void insertCus(String file) {
        try {
            new File(file).createNewFile();
        } catch (IOException e) {
        }
        try (FileWriter ret = new FileWriter(file, true)) {
            String name = Input.getString("Customer name : ", Customer.NAME_VALID);
            int phone = Input.getInt("Phone : ", 8000000, 8999999);
            ret.write(String.format("%s, %s\n", name, Integer.toString(phone)));
            System.out.println("Successfull!");
        } catch (IOException e) {
        }
    }

    public static void insertData(String file) {
        try {
            new File(file).createNewFile();
        } catch (IOException e) {
        }
        try (FileWriter ret = new FileWriter(file, true)) {
            int phone = Input.getInt("Phone : ", 8000000, 8999999);
            int duration = Input.getInt("duration : ", 1, 120);
            double time = Input.getDouble();
            String date = Input.getString("date ", "[0-9]{1,2}/[0-9]{1,2}/[0-9]+");
            String type = Input.getString("type ", DataStorage.VALID_TYPES);
//            String out = Integer.toString(phone) + " " + Integer.toString(duration)
//                    + " " + Double.toString(time) + " " + date + " " + type;
//            ret.write(out + "\n");
            ret.write(String.format("%d %d %.0f %s %s\n", phone, duration, time, date, type));
            System.out.println("Successfull!");
        } catch (IOException e) {
        }
    }

    public static BinarySearchTree<Management> load(String customerFile, String callFile) {
        List<Customer> customerList = Customer.setCusData(customerFile);
        List<DataStorage> callList = DataStorage.setPhoneData(callFile);
        BinarySearchTree<Management> tree = new BinarySearchTree<>();
        for (Customer cus : customerList) {
            tree.add(new Management(cus));
        }
        for (DataStorage call : callList) {
            Management data = tree.get(new Management(call.getPhone()));
            if (data != null) {
                System.out.println("true");
                data.addCall(call);
            }
        }
        //tree.BFS();
        return tree;
    }
    
    public double getFee(List<DataStorage> callList) {
        double fee = 0;
        for (DataStorage dataStorage : callList) {
            fee += dataStorage.getFee();
        }
        return fee;
    }

    public String getTypes() {
        type listType = new type();
        for (DataStorage call : callList) {
            for (int i = 0; i < 4; i++) {
                if (call.getType().equalsIgnoreCase(listType.name[i])) {
                    listType.frequence[i]++;
                }
            }
        }
        String types = "";
        for (int i = 0; i < 4; ++i) {
            types += String.format("%s:%d ", listType.name[i], listType.frequence[i]);
        }
        return types;
    }

    public static void save(BinarySearchTree<Management> dataTree, String file) {
        try (FileWriter ret = new FileWriter(file)) {
            double totalFee = 0;
            List<DataStorage> totalCalls = new LinkedList<>();
            for (Management data : dataTree.getList()) {
                ret.write(String.format("%s %.0f %s\n", data.getCustomer(), data.getFee(data.getCallList()), data.getTypes()));
                totalFee += data.getFee(data.getCallList());
                totalCalls.addAll(data.getCallList());
            }
            ret.write("====================================================================================================\n");
            ret.write(String.format("Tổng tiền thu được: %.0f\n", totalFee));
            ret.write("====================================================================================================\n");
            Collections.sort(totalCalls, (c1, c2) -> {
                int i1 = DataStorage.VALID_TYPES.indexOf(c1.getType());
                int i2 = DataStorage.VALID_TYPES.indexOf(c2.getType());
                if (i1 == i2) {
                    return Integer.compare(c1.getPhone(), c2.getPhone());
                }
                return Integer.compare(i1, i2);
            });
            for (DataStorage call : totalCalls) {
                ret.write(call + "\n");
            }
            System.out.println("Successfull!");
        } catch (IOException e) {
        }
    }

}
