/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Context;

import Model.Product;
import Model.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author duypham0705
 */
public class ProductDAO {

    //Tạo các thành phần để kết nổi và xử lí dữ liệu
    Connection cnn; // Kết nối đến DB
    Statement stm; // Thực thi các câu lệnh SQl
    ResultSet rs; // Lưu trữ và xử lí dữ liệu

    private void connectDB() {
        try {
            cnn = (new DBContext()).getConnection();
            System.out.println("Connect successfully !");
        } catch (Exception e) {
            System.out.println("Connect error : " + e.getMessage());
        }
    }

    public ProductDAO() {
        connectDB();
    }

    public ArrayList<Product> getAllProduct() {
        ArrayList<Product> list = new ArrayList<>();
        try {
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String strSelect = "select * from tblProduct ";
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {
                String ProductID = rs.getString(1);
                String ProductName = rs.getString(2);
                String Unit = rs.getString(3);
                double Price = Double.valueOf(rs.getString(4));
                String Image = rs.getString(5);
                list.add(new Product(ProductID, ProductName, Unit, Price, Image));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public ArrayList<Product> getByPage(ArrayList<Product> listAll, int start, int end) {
        ArrayList<Product> list = new ArrayList<>();
        for (int i = start; i < end; i++) {
            list.add(listAll.get(i));
        }
        return list;
    }

    public void Delete(String id) {
        try {
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String strDelete = "delete tblProduct where account ='" + id + "'";
            stm.execute(strDelete);
            System.out.println("success");
        } catch (Exception e) {
            System.out.println("Update Error : " + e.getMessage());
        }
    }

    public Product getByID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
