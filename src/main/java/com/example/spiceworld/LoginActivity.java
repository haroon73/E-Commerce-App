package com.example.spiceworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.spiceworld.DB.AppDateBase;
import com.example.spiceworld.DB.SpiceWorldDAO;
import com.example.spiceworld.Variables.User;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    SpiceWorldDAO SpiceWorldDBAccess;

    EditText UserName;
    EditText Password;

    Button LogingButton;
    User userLoginName;
    SharedPreferences mSharedPreferences;
    SharedPreferences.Editor mEditor;

//    SharedPreferences.Editor mEditor = getPreferences("LoginUser" ,MODE_PRIVATE ).edit();
//    mEd
//    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


//        binding = ActivityLoginBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());

        UserName = findViewById(R.id.userName);
        Password = findViewById(R.id.userPassword);
        LogingButton = findViewById(R.id.userButton);


        SpiceWorldDBAccess  = Room.databaseBuilder(this, AppDateBase.class, AppDateBase.DATABASE_NAME)
                .allowMainThreadQueries()
                .build()
                .SpiceWorldDAO();

        CreatAdmin(); // if there is admin database to print it

        mSharedPreferences = getSharedPreferences("LoginUserName" , Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();



        LogingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              userLoginName =  checkLoginValidtion(); //calling a method

              if(userLoginName != null){ // check if the user voliade
                  if(userLoginName.getUserName().equals("admin2")) {

                      Toast.makeText(LoginActivity.this, "I am if" + userLoginName , Toast.LENGTH_LONG).show();
                      mEditor.putString("UserName", userLoginName.getUserName()); // adding data in the preference
                      mEditor.commit();

                      // to change activity
                      Intent intent = new Intent(LoginActivity.this, LandingPage.class);
                      startActivity(intent);
                  }
                  else {
                      mEditor.putString("UserName", userLoginName.getUserName()); // adding data in the preference
                      mEditor.commit();

                      Intent intent = new Intent(LoginActivity.this, UserActivity.class);
                      startActivity(intent);
                  }
              }


            }
        });


    }
    private void CreatAdmin(){
        User admin , admin1;
        if(!IsThereAnAdmin()){ // checking admin
            admin = new User("Wali", "Khan", "admin2", "admin2", true);

            SpiceWorldDBAccess.insert(admin); // insert admin in the database
        }
        else{
            User user = new User("Gul", "Sheer", "testuser1", "1234", false);
            SpiceWorldDBAccess.insert(user);
        }










//        UserName.setText(SpiceWorldDBAccess.getUserByUserName("Admin").getUserName());
    }

    // this check if there is an admin in the Database
    private boolean IsThereAnAdmin() {
        if (SpiceWorldDBAccess.getUserByUserName("admin2") == null ) {
            return false;
        } else {
            return true;
        }
    }



    // checking if the user name and passowrd are corrct
    private User checkLoginValidtion(){

        User user;
        user = SpiceWorldDBAccess.getUserByUserName(UserName.getText().toString());

        // checking if the user password enter equal the database password return the user name
        if(user.getPassword().equals(Password.getText().toString()) ){

            return user; // to return the user object
        }
        else {
           return null;
        }
    }


}