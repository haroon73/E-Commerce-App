package com.example.spiceworld.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.spiceworld.Variables.AddSpiceByUser;
import com.example.spiceworld.Variables.FeedBack;
import com.example.spiceworld.Variables.Payment;
import com.example.spiceworld.Variables.ShippinAddress;
import com.example.spiceworld.Variables.Spice;
import com.example.spiceworld.Variables.User;

import java.util.List;
@Dao
public interface SpiceWorldDAO {

    @Insert
    void insert(User... users);

    @Update
    void update(User... users);

    @Delete
    void delete(User users);

    @Query("SELECT * FROM " + AppDateBase.USER_TABLE )
    List<User> getUsers();

    @Query("SELECT * FROM " + AppDateBase.USER_TABLE + " WHERE mUserId = :UserId")
    User getUserByUserId(int UserId);


    // brought new changes
    @Query("SELECT * FROM " + AppDateBase.USER_TABLE + " WHERE UserName = :mUserName")
   User getUserByUserName(String  mUserName);


    @Insert
    void insert(Spice... spices);

    @Update
    void update(Spice... spices);

    @Delete
    void delete(Spice spices);

    @Query("SELECT * FROM " + AppDateBase.SPICE_TABLE)
    List<Spice> getSpices();

    @Query("SELECT * FROM " + AppDateBase.SPICE_TABLE + " WHERE mSpiceId = :SpiceId")
    List<Spice> getSpiceBySpiceId(int SpiceId);

    @Query("SELECT * FROM " + AppDateBase.SPICE_TABLE + " WHERE spiceName = :mSpiceName")
    Spice getSpiceBySpiceName(String mSpiceName);


    @Insert
    void insert(AddSpiceByUser... addSpiceByUsers);

    @Update
    void update(AddSpiceByUser... addSpiceByUsers);

    @Delete
    void delete(AddSpiceByUser addSpiceByUser);

    @Query("SELECT * FROM " + AppDateBase.ADD_SPICE_TABLE)
    List<AddSpiceByUser> getAllAddSpiceByUser();

    @Query("SELECT * FROM " + AppDateBase.ADD_SPICE_TABLE + " WHERE addSpiceId = :mAddSpiceId")
    List<AddSpiceByUser> getAddSpiceByUserById(int mAddSpiceId);

    @Query("SELECT * FROM " + AppDateBase.ADD_SPICE_TABLE + " WHERE addSpiceName = :mAddSpiceName")
    AddSpiceByUser getAddSpiceByUserByName(String mAddSpiceName);
    @Query("SELECT * FROM " +AppDateBase.ADD_SPICE_TABLE + " WHERE userName = :mUserN")
     AddSpiceByUser getAddSpiceByUserName(String mUserN);
    ///

    @Insert
    void insert(Payment...payments);

    @Update
    void update(Payment...payments);

    @Delete
    void delete(Payment payment);

    @Query("SELECT * FROM " + AppDateBase.PAYMENT_TABLE)
    List<Payment> getAllPayment();

    @Query("SELECT * FROM " + AppDateBase.PAYMENT_TABLE + " WHERE payId = :mPayId")
    List<Payment> getPayById(int mPayId);

    @Query("SELECT * FROM " + AppDateBase.PAYMENT_TABLE + " WHERE cardInfo = :mCardInfo")
    Payment getCardInfobyNo(String  mCardInfo);
    @Query("SELECT * FROM " + AppDateBase.PAYMENT_TABLE + " WHERE userN = :mUserName")
    Payment getPaymentByUserName(String mUserName);

    @Insert
    void insert(FeedBack...feedBacks);

    @Update
    void update(FeedBack...feedBacks);

    @Delete
    void delete(FeedBack feedBack);

    @Query("SELECT * FROM " + AppDateBase.FEEDBACK_TABLE)
    List<FeedBack> getAllFeedBacks();

    @Query("SELECT * FROM " +AppDateBase.FEEDBACK_TABLE + " WHERE feedBackId = :mFeedBackId")
    List<FeedBack> getFeedBackById(int mFeedBackId);

    @Query("SELECT * FROM "+ AppDateBase.FEEDBACK_TABLE + " WHERE feedBack = :mFeedBack")
    FeedBack getFeedBackByFeed(String mFeedBack);

    @Query("SELECT * FROM " + AppDateBase.FEEDBACK_TABLE + " WHERE userName = :mUserName")
    FeedBack getFeedByUserName(String mUserName);


    @Insert
    void insert(ShippinAddress...shippinAddresses);

    @Update
    void update(ShippinAddress... shippinAddresses);

    @Delete
    void delete(ShippinAddress shippinAddress);

    @Query("SELECT * FROM " + AppDateBase.SHIPPING_TABLE)
    List<ShippinAddress> getAllShippingAdd();

    @Query("SELECT * FROM " + AppDateBase.SHIPPING_TABLE + " WHERE shippingid = :mshId")
    List<ShippinAddress> getShippingById(int mshId);

    @Query("SELECT * FROM " + AppDateBase.SHIPPING_TABLE + " WHERE address = :mAddress")
    ShippinAddress getShippingbyAddress(String mAddress);

    @Query("SELECT * FROM " + AppDateBase.SHIPPING_TABLE + " WHERE userNam = :mUserN")
     ShippinAddress getShipByUserName(String mUserN);

}
