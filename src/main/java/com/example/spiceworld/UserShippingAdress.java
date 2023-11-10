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
import com.example.spiceworld.Variables.ShippinAddress;
import com.example.spiceworld.databinding.ActivityUserShippingAdressBinding;

public class UserShippingAdress extends AppCompatActivity {
    ActivityUserShippingAdressBinding binding;

    private EditText add , phone , uName;
    private Button sBtn , bbtn;

    private SpiceWorldDAO mSpiceWorldDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_shipping_adress);
           getDatabase();
        binding = ActivityUserShippingAdressBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        add = binding.addEdit;
        phone = binding.phoneEdit;
        uName = binding.userEdit;

        sBtn = binding.subBtn;
        bbtn = binding.backBtn;

        sBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitSpice();
            }
        });
   bbtn.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           Intent intent = new Intent(UserShippingAdress.this , UserActivity.class);
           startActivity(intent);
       }
   });

    }// End

    private void getDatabase() {
        mSpiceWorldDAO = Room.databaseBuilder(this , AppDateBase.class , AppDateBase.DATABASE_NAME)
                .allowMainThreadQueries()
                .build()
                .SpiceWorldDAO();
    }


    //    // submit methdo
    private  void submitSpice(){
        String  cNo = add.getText().toString().trim();

        String dInfo = phone.getText().toString().trim();

        String  zInfo = uName.getText().toString().trim();


        ShippinAddress shippinAddress = new ShippinAddress(cNo , dInfo , zInfo);

        mSpiceWorldDAO.insert(shippinAddress);


        //




    }
}