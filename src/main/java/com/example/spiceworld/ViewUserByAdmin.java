package com.example.spiceworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spiceworld.DB.AppDateBase;
import com.example.spiceworld.DB.SpiceWorldDAO;
import com.example.spiceworld.Variables.Spice;
import com.example.spiceworld.Variables.User;
import com.example.spiceworld.databinding.ActivityViewUserByAdminBinding;

import java.util.ArrayList;
import java.util.List;

public class ViewUserByAdmin extends AppCompatActivity {

       ActivityViewUserByAdminBinding binding;

       private TextView viewUsers;

       private Button viewBtn , backBtn;

    private List<User> mUserList;
    private  List<User> mList;
    private int userId =-1;
    private User mUser;

    private SpiceWorldDAO mSpiceWorldDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_user_by_admin);


        binding = ActivityViewUserByAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewUsers = binding.ViewUser;

        viewBtn = binding.ViewUserBtn;
        backBtn = binding.backAdminBtn;

      getDatabase();
        viewUsers.setMovementMethod(new ScrollingMovementMethod());
        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showUser();
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewUserByAdmin.this , Admin.class);
                startActivity(intent);
            }
        });



    }

    private void showUser() {






       mUserList = mSpiceWorldDAO.getUsers();

        if(!mUserList.isEmpty()){
            StringBuilder sb = new StringBuilder();
            for(User user: mUserList){
                sb.append(user.toString());
            }
            viewUsers.setText((sb.toString()));

        }
        else {
            viewUsers.setText("User list is empty!!!");

        }
    }

    private void getDatabase() {
        mSpiceWorldDAO = Room.databaseBuilder(this , AppDateBase.class , AppDateBase.DATABASE_NAME)
                .allowMainThreadQueries()
                .build()
                .SpiceWorldDAO();
    }
}