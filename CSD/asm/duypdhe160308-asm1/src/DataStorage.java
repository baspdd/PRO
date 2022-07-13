
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
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
public class DataStorage {

    static final DateTimeFormatter VALID_DOB = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static final List<String> VALID_TYPES = Arrays.asList("NH", "LC", "X", "RX");

    private int phone;
    private int duration;
    private int time;
    private LocalDate date;
    private String type;

    public DataStorage(int phone, int duration, int time, LocalDate date, String type) {
        this.phone = phone;
        this.duration = duration;
        this.time = time;
        this.date = date;
        this.type = type;
    }

    public int getPhone() {
        return this.phone;
    }

    public String getType() {
        return this.type;
    }

    public double getFee() {
        double Fee = 400 * duration * (VALID_TYPES.indexOf(type) + 1);
        if (time >= 23 * 60 || time <= 5 * 60) {
            Fee *= 0.7;
        }
        return Fee;
    }

    public String toString() {
        return String.format("%s %d %d.%d %s %s", phone, duration, time / 60, time % 60, date.format(VALID_DOB), type);
    }

    public static List<DataStorage> setPhoneData(String file) {
        List<DataStorage> PhoneList = new LinkedList<>();
        try {
            new File(file).createNewFile();
        } catch (IOException e) {
        }
        try (BufferedReader inp = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = inp.readLine()) != null) {
                try {
                    String[] args = line.trim().split(" ");
                    int phone = Integer.parseInt(args[0]);
                    int duraion = Integer.parseInt(args[1]);
                    String[] time = args[2].split("\\.");
                    int hour = Integer.parseInt(time[0]);
                    int minute = Integer.parseInt(time[1]);
                    LocalDate date = LocalDate.parse(args[3], VALID_DOB);
                    String type = args[4];
                    if (phone < 8000000 || phone > 8999999) {
                        continue;
                    }
                    if (duraion < 1 || duraion > 120) {
                        continue;
                    }
                    if (hour < 0 || hour > 23 || minute < 0 || minute > 59) {
                        continue;
                    }
                    if (!VALID_TYPES.contains(type)) {
                        continue;
                    }
                    PhoneList.add(new DataStorage(phone, duraion, hour * 60 + minute, date, type));
                } catch (RuntimeException e) {
                }
            }
        } catch (IOException e) {
        }
        return PhoneList;
    }

}
