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
import com.example.spiceworld.databinding.ActivityShowItemBinding;

import java.util.List;

public class ShowItemActivity extends AppCompatActivity {
    ActivityShowItemBinding binding;
    private TextView showItem1;

    private Button backbtn ,search;

    private List<Spice> mSpiceList;
    private SpiceWorldDAO mSpiceWorldDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_item);

        binding = ActivityShowItemBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        showItem1 = binding.showItemView1;

        backbtn = binding.backBtn;
        search = binding.searchSpiceBtn;
        showItem1.setMovementMethod(new ScrollingMovementMethod());

        callDataBase();

        // Search Button
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displaySpice();
            }


        });




        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowItemActivity.this , UserActivity.class);
                startActivity(intent);
            }
        });

    }

    private void displaySpice() {
        mSpiceList = mSpiceWorldDAO.getSpices();
        if(!mSpiceList.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Spice spice : mSpiceList) {
                sb.append(spice.toString());
            }
            showItem1.setText((sb.toString()));
        }
        else {
            showItem1.setText(R.string.no_cook_yet);

        }
    }

    private void callDataBase() {
        mSpiceWorldDAO = Room.databaseBuilder(this , AppDateBase.class , AppDateBase.DATABASE_NAME)
                .allowMainThreadQueries()
                .build()
                .SpiceWorldDAO();
    }
}