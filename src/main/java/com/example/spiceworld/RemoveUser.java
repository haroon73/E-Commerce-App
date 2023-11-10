package com.example.spiceworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spiceworld.DB.AppDateBase;
import com.example.spiceworld.DB.SpiceWorldDAO;
import com.example.spiceworld.Variables.User;

import java.util.List;

public class RemoveUser extends AppCompatActivity {

    private EditText  userName ;
    private User mUser;
    private Button removeUserBtn1 , backBtn;
    private SpiceWorldDAO mSpiceWorldDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_user);


        userName = findViewById(R.id.RemoveUserName);

          getDatabase();
        removeUserBtn1 = findViewById(R.id.RemoveUserByAdminbtn1);
        backBtn = findViewById(R.id.backtoAdminbtn);

        removeUserBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String uName = userName.getText().toString().trim();

               mUser = mSpiceWorldDAO.getUserByUserName(uName);
                mSpiceWorldDAO.delete(mUser);

            }
        });




        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RemoveUser.this , Admin.class);
                startActivity(intent);
            }
        });

    }

    private void getDatabase() {
        mSpiceWorldDAO = Room.databaseBuilder(this , AppDateBase.class , AppDateBase.DATABASE_NAME)
                .allowMainThreadQueries()
                .build()
                .SpiceWorldDAO();
    }
}