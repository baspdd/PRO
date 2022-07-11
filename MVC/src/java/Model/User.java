/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


/**
 *
 * @author duypham0705
 */
public class User {

    private String acc, pass, name, gender, adress, dob;

    public User() {
    }

    public User(String acc, String pass) {
        this.acc = acc;
        this.pass = pass;
    }

    public User(String acc, String pass, String name, String gender, String adress, String dob) {
        this.acc = acc;
        this.pass = pass;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.adress = adress;
    }

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

   

  

   
}
