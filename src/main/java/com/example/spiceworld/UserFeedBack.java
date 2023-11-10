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
import com.example.spiceworld.Variables.FeedBack;
import com.example.spiceworld.Variables.Payment;
import com.example.spiceworld.databinding.ActivityUserFeedBackBinding;

public class UserFeedBack extends AppCompatActivity {

    ActivityUserFeedBackBinding binding;

    private EditText feed , star , userName;
    private Button fBtn , backBtn;

    private SpiceWorldDAO mSpiceWorldDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_feed_back);

        getDatabase();
        binding = ActivityUserFeedBackBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        feed = binding.feedBackEdit;
        star = binding.feedStarEdit;
        userName = binding.feedNameEdit;

        fBtn = binding.feedBtn;
        backBtn = binding.backBtn;

        fBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitSpice();
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserFeedBack.this , UserActivity.class);
                startActivity(intent);
            }
        });



    }//End of onCreate



    private void getDatabase() {
        mSpiceWorldDAO = Room.databaseBuilder(this , AppDateBase.class , AppDateBase.DATABASE_NAME)
                .allowMainThreadQueries()
                .build()
                .SpiceWorldDAO();
    }


    //    // submit methdo
    private  void submitSpice(){
        String  cNo = feed.getText().toString().trim();

        String dInfo = star.getText().toString().trim();

        String  zInfo = userName.getText().toString().trim();


        FeedBack feedBack = new FeedBack(cNo , dInfo , zInfo);

        mSpiceWorldDAO.insert(feedBack);


        //




    }
}