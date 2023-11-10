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
import com.example.spiceworld.databinding.ActivityViewSpiceToAdminBinding;

import java.util.List;

public class ViewSpiceToAdmin extends AppCompatActivity {
       ActivityViewSpiceToAdminBinding binding;
    private TextView viewSpice;

    private Button viewListBtn , addSpiceBtn;

    private List<Spice> mSpiceList;

    private SpiceWorldDAO mSpiceWorldDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_spice_to_admin);
        getDatabase();
        binding = ActivityViewSpiceToAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewSpice = binding.ViewSpiceAdmin;

        // to show the lise by clicking
        viewListBtn = binding.button;

        // take back to AddSpiceActivity
        addSpiceBtn = binding.button2;
        viewSpice.setMovementMethod(new ScrollingMovementMethod());
        refreshDisplay();
//        viewListBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                refreshDisplay();
//            }
//        });

        //take back to addSpice activity

        addSpiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewSpiceToAdmin.this , AddSpiceByAdmin.class);
                startActivity(intent);
            }
        });


    }


    private void refreshDisplay(){
        mSpiceList = mSpiceWorldDAO.getSpices();
        if(!mSpiceList.isEmpty()){
            StringBuilder sb = new StringBuilder();
            for(Spice spice: mSpiceList){
                sb.append(spice.toString());
            }
            viewSpice.setText((sb.toString()));
            Toast.makeText(ViewSpiceToAdmin.this , "Add to date base in refershDisplay()" , Toast.LENGTH_LONG).show();
        }
        else {
            viewSpice.setText(R.string.no_cook_yet);
            Toast.makeText(ViewSpiceToAdmin.this , " Not Add to date base in submitSpice()" , Toast.LENGTH_LONG).show();
        }

    }
    private void getDatabase() {
        mSpiceWorldDAO = Room.databaseBuilder(this , AppDateBase.class , AppDateBase.DATABASE_NAME)
                .allowMainThreadQueries()
                .build()
                .SpiceWorldDAO();
    }

}