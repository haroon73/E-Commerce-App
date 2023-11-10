package com.example.spiceworld.Variables;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.spiceworld.DB.AppDateBase;

@Entity(tableName = AppDateBase.PAYMENT_TABLE)
public class Payment {

    @PrimaryKey(autoGenerate = true)
    private int payId;

    private String  cardInfo;
    private  String cardDate;
    private String  zipCode;

    private String userN;

    public Payment(String cardInfo, String cardDate, String zipCode, String userN) {
        this.cardInfo = cardInfo;
        this.cardDate = cardDate;
        this.zipCode = zipCode;
        this.userN = userN;
    }

    // getter and setter

    public int getPayId() {
        return payId;
    }

    public void setPayId(int payId) {
        this.payId = payId;
    }

    public String getCardInfo() {
        return cardInfo;
    }

    public void setCardInfo(String cardInfo) {
        this.cardInfo = cardInfo;
    }

    public String getCardDate() {
        return cardDate;
    }

    public void setCardDate(String cardDate) {
        this.cardDate = cardDate;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getUserN() {
        return userN;
    }

    public void setUserN(String userN) {
        this.userN = userN;
    }


    // tostring


    @Override
    public String toString() {
        return "PaymentId: " + payId +" " +
                "Card No: " + cardInfo + " " + "Expiration date: " + cardDate + "\n"
                + "Zip code:" + zipCode +" "+ "User Name: " + userN + "\n\n";

    }
}
