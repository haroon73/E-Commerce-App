package com.example.spiceworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.spiceworld.DB.AppDateBase;
import com.example.spiceworld.DB.SpiceWorldDAO;
import com.example.spiceworld.Variables.User;

public class UserActivity extends AppCompatActivity {
   private SpiceWorldDAO mSpiceWorldDAOAccess;
   private TextView showUserName;
   private Button searchBtn , addSpicebtn , cartBtn , cancelBtn , logoutbtn , paymnetBtn , feed , shippment;

   private SpiceWorldDAO mSpiceWorldDAO;

   private User mUser;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        showUserName = findViewById(R.id.showUserName);
        shippment = findViewById(R.id.shippingtBtn);
        showUserName = findViewById(R.id.showUserName);
        feed = findViewById(R.id.feedByuSERtBtn);
        paymnetBtn = findViewById(R.id.paymnetBtn);
        searchBtn = findViewById(R.id.serachbtn);
        addSpicebtn = findViewById(R.id.addspicebtn);
        cartBtn = findViewById(R.id.shoppingcartbtn);
        cancelBtn = findViewById(R.id.cancelspicesbtn);
        logoutbtn = findViewById(R.id.logoutuserbtn);

        mSpiceWorldDAOAccess = Room.databaseBuilder(this, AppDateBase.class, AppDateBase.DATABASE_NAME)
                .allowMainThreadQueries()
                .build()
                .SpiceWorldDAO();


      // Button to show all spice list to the user
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this , ShowItemActivity.class);
                startActivity(intent);
            }
        });

        // shipping btn
        shippment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this , UserShippingAdress.class);
                startActivity(intent);
            }
        });

        // feedback button
        feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this , UserFeedBack.class);
                startActivity(intent);
            }
        });

        // Button to addSpice by user
        addSpicebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this , AddSpiceActivity.class);
                startActivity(intent);
            }
        });


        // Button from User activty to Spice cart activity
        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this , SpiceCartActivity.class);
                startActivity(intent);
            }
        });

        //paymnet button
        paymnetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this , PaymentByUser.class);
                startActivity(intent);
            }
        });

        // Button to cancel spice from user activity

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this , CancelSpiceActivity.class);
                startActivity(intent);
            }
        });

        // Button to logout from user activity back to the login activity

        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this , LoginActivity.class);
                startActivity(intent);
            }
        });




    }


}