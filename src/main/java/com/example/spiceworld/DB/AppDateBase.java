package com.example.spiceworld.DB;

import android.content.Context;

import androidx.room.AutoMigration;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.spiceworld.Variables.AddSpiceByUser;
import com.example.spiceworld.Variables.FeedBack;
import com.example.spiceworld.Variables.Payment;
import com.example.spiceworld.Variables.ShippinAddress;
import com.example.spiceworld.Variables.Spice;
import com.example.spiceworld.Variables.User;

@Database(entities = {User.class , Spice.class , AddSpiceByUser.class , Payment.class , FeedBack.class , ShippinAddress.class} , version = 1)

public abstract class AppDateBase extends RoomDatabase {

    public static final String DATABASE_NAME = "SpiceWorld.db";

    public static final String USER_TABLE = "User_table";

    public static final String SPICE_TABLE = "Spice_table";

    public static final String ADD_SPICE_TABLE = "Add_Spice_Table";
    public static final String PAYMENT_TABLE = "Payment_Table";
    public static final String FEEDBACK_TABLE = "FeedBack_Table";
    public static final String SHIPPING_TABLE = "Shipping_Table";

    // Volatile means it may only be accessed from main memory

    private static volatile AppDateBase instance;
    private static final Object LOCK = new Object();

    // never called dirctly. Room deos all the work with this. That is why it is abstract.
    // need onr of those for each DAO

    public abstract SpiceWorldDAO SpiceWorldDAO();

    public static AppDateBase getInstance(Context context){
        if (instance == null){
            synchronized (LOCK){
                if (instance == null){
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDateBase.class,
                            DATABASE_NAME).build();

                }
            }
        }
        return instance;
    }




}
