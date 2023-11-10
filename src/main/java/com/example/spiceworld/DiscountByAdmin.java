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
import com.example.spiceworld.Variables.Spice;
import com.example.spiceworld.databinding.ActivityDiscountByAdminBinding;

public class DiscountByAdmin extends AppCompatActivity {

    ActivityDiscountByAdminBinding binding;

    private EditText spiceName , discountNo;
    private Button discountBtn , viewbtn;

    private SpiceWorldDAO mSpiceWorldDAO;

    private Spice mSpice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discount_by_admin);

        getDatabase();

        binding = ActivityDiscountByAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        spiceName = binding.spiceNameEdit;
        discountNo = binding.discountEdit;

        discountBtn = binding.discountBtn;
        viewbtn = binding.backBtn;

        discountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String spiceN = spiceName.getText().toString().trim();
                String discount = discountNo.getText().toString().trim();

                mSpice = mSpiceWorldDAO.getSpiceBySpiceName(spiceN);
                mSpice.setDiscount(Integer.parseInt(discount));
                mSpiceWorldDAO.update(mSpice);
            }
        });




        viewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DiscountByAdmin.this , ViewSpiceToAdmin.class);
                startActivity(intent);
            }
        });



    }//end of onCreate


    private void getDatabase() {
        mSpiceWorldDAO = Room.databaseBuilder(this , AppDateBase.class , AppDateBase.DATABASE_NAME)
                .allowMainThreadQueries()
                .build()
                .SpiceWorldDAO();
    }
}