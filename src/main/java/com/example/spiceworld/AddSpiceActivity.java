package com.example.spiceworld;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.spiceworld.DB.AppDateBase;
import com.example.spiceworld.DB.SpiceWorldDAO;
import com.example.spiceworld.Variables.AddSpiceByUser;
import com.example.spiceworld.Variables.Spice;
import com.example.spiceworld.Variables.User;
import com.example.spiceworld.databinding.ActivityAddSpiceBinding;

import java.security.PrivateKey;
import java.util.List;

public class AddSpiceActivity extends AppCompatActivity {
    private static final String USER_ID_KEY= "com.example.spiceworld.UserIdKey";
    private static final String PREFENCES_KEY = "com.example.spiceworld.PREFENCES_KEY";
    ActivityAddSpiceBinding binding;
    private TextView addSpiceV1;

    private EditText addSpice , addUserNme , addQuan;
    private Button backUserBtn , spiceBtn;

    private SpiceWorldDAO mSpiceWorldDAO;
    private List<AddSpiceByUser> mSpiceList;


    SharedPreferences mSharedPreferences = null;
    SharedPreferences.Editor mEditor;
//    private int userId = -1;
    private User userId;


    private User mUser;
    private Spice mSpice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_spice);
         getDatabase();  // CALLING METHOD



       binding = ActivityAddSpiceBinding.inflate(getLayoutInflater());
       setContentView(binding.getRoot());


       addSpiceV1 = binding.showSpiceAddView1;
       addSpice  = binding.addSpiceNameEdit;
       addUserNme = binding.addSpiceNameEdit2;
       addQuan = binding.addSpiceNameEdit3;

       backUserBtn = binding.addSpiceBtnToUser;
       spiceBtn = binding.addSpiceBtn;

        addSpiceV1.setMovementMethod(new ScrollingMovementMethod());

        mSharedPreferences = getSharedPreferences("LoginUserName" , Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();


        spiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            userId = checkUserId();
             if(userId != null){
                 submitSpice();
                 mEditor.putString("UserName", userId.getUserName()); // adding data in the preference
                 mEditor.commit();

             }




            }


        });













        // Button to user activity from Addspice activity
        backUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddSpiceActivity.this , UserActivity.class);
                startActivity(intent);
            }
        });

    } //End of OnCreate

    private User checkUserId() {
        User user;
        String name = addUserNme.getText().toString().trim();
        user = mSpiceWorldDAO.getUserByUserName(name);

        // checking if the user password enter equal the database password return the user name
        if(user.getUserName().equals(name) ){

            return user; // to return the user object
        }
        else {
            return null;
        }

    }
    // method


    //method;

    private  void submitSpice(){
        String userName = addUserNme.getText().toString().trim(); // reading user name from input

        String spiceName = addSpice.getText().toString().trim(); // reading spice name from imput

        int spiceQ = Integer.parseInt(addQuan.getText().toString().trim());
        mUser = mSpiceWorldDAO.getUserByUserName(userName); // getting user info from database

        mSpice = mSpiceWorldDAO.getSpiceBySpiceName(spiceName); // getting spice info from database

        int userId = mUser.getUserId(); // getting user id
        int dis = mSpice.getDiscount();
        String nSpice = mSpice.getSpiceName(); // getting spcie name
        double price = mSpice.getSpicePrice(); // getting spice price
//        int qua = mSpice.getSpiceQuantity(); // getting spice quantiy

      double total = Double.valueOf(spiceQ)  * price;


        AddSpiceByUser addSpiceByUser = new AddSpiceByUser(nSpice , price , spiceQ , userName ,  total, dis); // creating AddSpiceByuser objet

        mSpiceWorldDAO.insert(addSpiceByUser);  // adding new data to database

    }



    // method
//   private void addUserPref(mUserId){
//
//   }


    // DATABASE METHOD
    private void getDatabase() {
        mSpiceWorldDAO = Room.databaseBuilder(this , AppDateBase.class , AppDateBase.DATABASE_NAME)
                .allowMainThreadQueries()
                .build()
                .SpiceWorldDAO();
    }

}