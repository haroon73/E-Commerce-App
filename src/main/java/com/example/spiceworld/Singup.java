package com.example.spiceworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.spiceworld.DB.AppDateBase;
import com.example.spiceworld.DB.SpiceWorldDAO;
import com.example.spiceworld.Variables.User;

public class Singup extends AppCompatActivity {
    private SpiceWorldDAO SpiceWorldDBAccess; // creating reference of interface
    private EditText firstName;
    private EditText lastName;
    private EditText userName;
    private EditText password;
    private Button singUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        firstName = findViewById(R.id.firstNameSingup);
        lastName = findViewById(R.id.lastNameSingup);
        userName = findViewById(R.id.userNameSingup);
        password = findViewById(R.id.passwordSingup);
        singUp = findViewById(R.id.buttonSingup);


        SpiceWorldDBAccess  = Room.databaseBuilder(this, AppDateBase.class, AppDateBase.DATABASE_NAME)
                .allowMainThreadQueries()
                .build()
                .SpiceWorldDAO();


        singUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // calling method
                storeUserInfoDB();
                // to change activity
                Intent intent = new Intent(Singup.this, LoginActivity.class);
                startActivity(intent);
            }
        });





    }
    // the storeUserInfoDB method get all user info and store it in database
    public void storeUserInfoDB(){
        User getNewUser;
        getNewUser = new User(firstName.getText().toString(), lastName.getText().toString(), userName.getText().toString(),
                password.getText().toString() ,false);

        // store in database
        SpiceWorldDBAccess.insert(getNewUser);
    }

}