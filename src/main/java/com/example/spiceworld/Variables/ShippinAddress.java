package com.example.spiceworld.Variables;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.spiceworld.DB.AppDateBase;

@Entity(tableName = AppDateBase.SHIPPING_TABLE)
public class ShippinAddress {
    @PrimaryKey(autoGenerate = true)
    private int shippingid;

    private String address;
    private String phoneNo;
    private String userNam;

    public ShippinAddress(String address, String phoneNo, String userNam) {
        this.address = address;
        this.phoneNo = phoneNo;
        this.userNam = userNam;
    }

    public int getShippingid() {
        return shippingid;
    }

    public void setShippingid(int shippingid) {
        this.shippingid = shippingid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getUserNam() {
        return userNam;
    }

    public void setUserNam(String userNam) {
        this.userNam = userNam;
    }

    @Override
    public String toString() {
        return "ShippinAddress : " +address + "\n" +
                "Phone no: " + phoneNo + "\n"+
                "User Name " + userNam + "\n\n";
    }
}
