package com.example.spiceworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spiceworld.DB.AppDateBase;
import com.example.spiceworld.DB.SpiceWorldDAO;
import com.example.spiceworld.Variables.FeedBack;
import com.example.spiceworld.Variables.Spice;
import com.example.spiceworld.databinding.ActivityViewFeedBackByAdminBinding;

import java.util.List;

public class viewFeedBackByAdmin extends AppCompatActivity {

    ActivityViewFeedBackByAdminBinding binding;

    private TextView view;
    private Button backBtn;

    private SpiceWorldDAO mSpiceWorldDAO;
    private List<FeedBack> mFeedBackList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_feed_back_by_admin);

        binding = ActivityViewFeedBackByAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        view = binding.textView5;
        backBtn = binding.button3;
        getDatabase();

        refreshDisplay();

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(viewFeedBackByAdmin.this , Admin.class);
                startActivity(intent);
            }
        });



    }//End


    private void refreshDisplay(){
        mFeedBackList = mSpiceWorldDAO.getAllFeedBacks();
        if(!mFeedBackList.isEmpty()){
            StringBuilder sb = new StringBuilder();
            for(FeedBack spice: mFeedBackList){
                sb.append(spice.toString());
            }
            view.setText((sb.toString()));

        }
        else {
            view.setText("No feed back you doing well");

        }

    }
    private void getDatabase() {
        mSpiceWorldDAO = Room.databaseBuilder(this , AppDateBase.class , AppDateBase.DATABASE_NAME)
                .allowMainThreadQueries()
                .build()
                .SpiceWorldDAO();
    }
}