package com.example.spiceworld.Variables;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.spiceworld.DB.AppDateBase;

@Entity(tableName = AppDateBase.ADD_SPICE_TABLE)
public class AddSpiceByUser {

    @PrimaryKey(autoGenerate = true)
    private int addSpiceId;

    private String addSpiceName;
    private double addSpicePrice;
    private int addSpiceQuantity;
    private double total;

    private String userName;
    private int discount;

    public AddSpiceByUser(String addSpiceName, double addSpicePrice, int addSpiceQuantity , String userName , double total , int discount) {
        this.addSpiceName = addSpiceName;
        this.addSpicePrice = addSpicePrice;
        this.addSpiceQuantity = addSpiceQuantity;
        this.userName =userName;
        this.total =total;
        this.discount = discount;
    }

    public int getAddSpiceId() {
        return addSpiceId;
    }

    public void setAddSpiceId(int addSpiceId) {
        this.addSpiceId = addSpiceId;
    }

    public String getAddSpiceName() {
        return addSpiceName;
    }

    public void setAddSpiceName(String addSpiceName) {
        this.addSpiceName = addSpiceName;
    }

    public double getAddSpicePrice() {
        return addSpicePrice;
    }

    public void setAddSpicePrice(double addSpicePrice) {
        this.addSpicePrice = addSpicePrice;
    }

    public int getAddSpiceQuantity() {
        return addSpiceQuantity;
    }

    public void setAddSpiceQuantity(int addSpiceQuantity) {
        this.addSpiceQuantity = addSpiceQuantity;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "   OrderNo : " + addSpiceId + "\n"+
                "   UserName : " + userName + "\n"+
                "Spice Name: " + addSpiceName + "\n" +
                "        $ : " + addSpicePrice + "\n" +
                "Discount % " + discount + "\n"+
                "  Quantity: " + addSpiceQuantity + "\n"
                +"________________________\n"+
                "Total $: " + total +"\n\n";
    }
}
