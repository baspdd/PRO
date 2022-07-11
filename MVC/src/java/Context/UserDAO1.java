/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Context;

import Model.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author duypham0705
 */
public class UserDAO1 extends DBContext1{

   
    

    //Tạo các thành phần để kết nổi và xử lí dữ liệu
    Statement stm; // Thực thi các câu lệnh SQl
    ResultSet rs; // Lưu trữ và xử lí dữ liệu

    public boolean checkLogin(String acc, String pass) {
        try {
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String strSelect = "select * from tblUser where account ='" + acc + "' and pass = '" + pass + "'";
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Login Error : " + e.getMessage());
        }
        return false;
    }

   

    public String getNameByAccount(String acc) {
        String name = "";
        try {
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String strSelect = "select * from tblUser where account ='" + acc + "'";
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {
                name = rs.getString(3);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return name;
    }

    public boolean checkAccount(String acc) {
        try {
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String strSelect = "select * from tblUser where account ='" + acc + "' ";
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Login Error : " + e.getMessage());
        }
        return false;
    }

    public void Update(String acc , String newpass) {
        try {
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String strUpdate = "update tblUser set pass = '" + newpass + "' where account ='" + acc + "'";
            stm.execute(strUpdate);
            System.out.println("success");
        } catch (Exception e) {
            System.out.println("Update Error : " + e.getMessage());
        }
    }

}
