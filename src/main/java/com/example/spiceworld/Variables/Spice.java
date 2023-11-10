package com.example.spiceworld.Variables;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.spiceworld.DB.AppDateBase;

@Entity(tableName = AppDateBase.SPICE_TABLE)
public class Spice {
   @PrimaryKey(autoGenerate = true)
    private int mSpiceId;
    private String spiceName;
    private double spicePrice;
    private int spiceQuantity;

    private int userId;
    private  int discount;




    // constructor
    public Spice(String spiceName, double spicePrice, int spiceQuantity , int discount ) {
        this.spiceName = spiceName;
        this.spicePrice = spicePrice;
        this.spiceQuantity = spiceQuantity;
        this.discount = discount;
//        this.userId = userId;
    }

    // getter and setter

    public int getSpiceId() {
        return mSpiceId;
    }

    public void setSpiceId(int spiceId) {
        mSpiceId = spiceId;
    }

    public String getSpiceName() {
        return spiceName;
    }

    public void setSpiceName(String spiceName) {
        this.spiceName = spiceName;
    }

    public double getSpicePrice() {
        return spicePrice;
    }

    public void setSpicePrice(double spicePrice) {
        this.spicePrice = spicePrice;
    }

    public int getSpiceQuantity() {
        return spiceQuantity;
    }

    public void setSpiceQuantity(int spiceQuantity) {
        this.spiceQuantity = spiceQuantity;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    // toString

    @Override
    public String toString() {
        return "Spice Name: " + spiceName + "\n" + "========"+"\n"
                +"$ " + spicePrice + "\n" + "========"+"\n"+
                "Discount % "+ discount +"\n" + "========"+ "\n"+
                "Quantity: " + spiceQuantity +"\n\n\n";
    }

}
