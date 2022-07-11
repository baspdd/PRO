/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author duypham0705
 */
public class Product {

    private String ProductID;
    private String ProductName;
    private String Unit;
    private Double Price;
    private String Image;

    public Product() {
    }

    public Product(String ProductID, String ProductName, String Unit, Double Price, String Image) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.Unit = Unit;
        this.Price = Price;
        this.Image = Image;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String ProductID) {
        this.ProductID = ProductID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String Unit) {
        this.Unit = Unit;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double Price) {
        this.Price = Price;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

}
