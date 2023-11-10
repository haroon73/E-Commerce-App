package com.example.spiceworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.spiceworld.DB.AppDateBase;
import com.example.spiceworld.DB.SpiceWorldDAO;
import com.example.spiceworld.Variables.AddSpiceByUser;
import com.example.spiceworld.Variables.User;
import com.example.spiceworld.databinding.ActivitySpiceCartBinding;

import java.util.ArrayList;
import java.util.List;

public class SpiceCartActivity extends AppCompatActivity {

     ActivitySpiceCartBinding binding;

      private TextView cartView1;

      private Button backbtnUser , cartBtn ,  updateBtn;
      private EditText userName  , spiceName;
      private List<AddSpiceByUser> mAddSpiceByUserList;
      private SpiceWorldDAO mSpiceWorldDAO;
      private   User user;
     private AddSpiceByUser mAddSpiceByUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spice_cart);
        getDatabase();
        binding = ActivitySpiceCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        cartView1 = binding.spiceCartView1;
        userName = binding.userNameEdit;
        spiceName = binding.userNameEdit2;
        cartBtn = binding.showCartBtn;
        backbtnUser = binding.backFromCartBtn;
        updateBtn = binding.updatecartBtn;

        cartView1.setMovementMethod(new ScrollingMovementMethod());
     // Button
        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userN = userName.getText().toString().trim();
                user = mSpiceWorldDAO.getUserByUserName(userN);
             String spiceN = spiceName.getText().toString().trim();
             mAddSpiceByUser = mSpiceWorldDAO.getAddSpiceByUserByName(spiceN);



            if(mAddSpiceByUser.getUserName().equals(userN)){
                refreshDisplay();
            }else {
                cartView1.setText("No spice to you "+ user.getUserName());
            }


            }
        });


        // Button from Spicecart to User activity
        backbtnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SpiceCartActivity.this , UserActivity.class);
                startActivity(intent);
            }
        });

        // update button
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SpiceCartActivity.this , UpdateCart.class);
                startActivity(intent);
            }
        });

    } // End of onCreate

    private void refreshDisplay() {

        mAddSpiceByUserList = mSpiceWorldDAO.getAllAddSpiceByUser();
        if(!mAddSpiceByUserList.isEmpty()){
            StringBuilder str = new StringBuilder();
            for(AddSpiceByUser sp: mAddSpiceByUserList){
                str.append(sp.toString());
            }


            cartView1.setText(str.toString());
        }else{
            cartView1.setText("No Spice to cook");
        }


    }

    private void getDatabase() {
        mSpiceWorldDAO = Room.databaseBuilder(this , AppDateBase.class , AppDateBase.DATABASE_NAME)
                .allowMainThreadQueries()
                .build()
                .SpiceWorldDAO();
    }
}