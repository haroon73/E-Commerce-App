package com.example.spiceworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.spiceworld.DB.AppDateBase;
import com.example.spiceworld.DB.SpiceWorldDAO;
import com.example.spiceworld.Variables.User;

public class LandingPage extends AppCompatActivity {

     TextView userNameLandPage;
     Button adminLandPage;
     Button LogoutLandPage;


    SharedPreferences sharedPreferences;
    User LoginUser;
    SpiceWorldDAO SpiceWorldDBAccess;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        sharedPreferences = getApplicationContext().getSharedPreferences("LoginUserName" , Context.MODE_PRIVATE);



        SpiceWorldDBAccess  = Room.databaseBuilder(this, AppDateBase.class, AppDateBase.DATABASE_NAME)
                .allowMainThreadQueries()
                .build()
                .SpiceWorldDAO();
        LoginUser = SpiceWorldDBAccess.getUserByUserName(sharedPreferences.getString("UserName" , "no data"));


        userNameLandPage = findViewById(R.id.userNameLandpage);
        userNameLandPage.setText(LoginUser.getUserName());

        adminLandPage = findViewById(R.id.adminButtonLandpage);
        LogoutLandPage = findViewById(R.id.userLogingLandingpage);

        // calling the method to show admin info
        adminIs();

        LogoutLandPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                      // calling the method
                     showLogout();


                    // to change activity
                    Intent intent = new Intent(LandingPage.this,LoginActivity.class);
                    startActivity(intent);
                }



        });

        // Button to Add spice by admin page
        adminLandPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LandingPage.this , Admin.class);
                startActivity(intent);
            }
        });

}

    private void adminIs(){
        if(LoginUser.isAdminIs()){
            adminLandPage.setVisibility(View.VISIBLE);
        }

    }

    private void showLogout(){
      sharedPreferences.edit().clear(); //
        sharedPreferences.edit().commit();
    }
}