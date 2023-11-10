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
import com.example.spiceworld.Variables.AddSpiceByUser;
import com.example.spiceworld.Variables.FeedBack;
import com.example.spiceworld.Variables.Payment;
import com.example.spiceworld.Variables.ShippinAddress;
import com.example.spiceworld.databinding.ActivityAdminCancelOrderBinding;

public class AdminCancelOrder extends AppCompatActivity {
    ActivityAdminCancelOrderBinding binding;

    private EditText userName;
    private Button cancelBtn , viewBtn;

    private SpiceWorldDAO mSpiceWorldDAO;

    private AddSpiceByUser mAddSpiceByUser;
    private ShippinAddress mShippinAddress;
    private Payment mPayment;
    private FeedBack mFeedBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_cancel_order);


        getDatabase();
        binding = ActivityAdminCancelOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        userName= binding.userEditCancelOrderAdmin;
        cancelBtn = binding.canceAdminBtn;
        viewBtn = binding.ViewCancelAdminBtn;

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = userName.getText().toString().trim();

                mAddSpiceByUser = mSpiceWorldDAO.getAddSpiceByUserName(name);
                mShippinAddress = mSpiceWorldDAO.getShipByUserName(name);
                mPayment = mSpiceWorldDAO.getPaymentByUserName(name);
                mFeedBack = mSpiceWorldDAO.getFeedByUserName(name);

                mSpiceWorldDAO.delete(mAddSpiceByUser);
                mSpiceWorldDAO.delete(mShippinAddress);
                mSpiceWorldDAO.delete(mPayment);
                mSpiceWorldDAO.delete(mFeedBack);
            }
        });


        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCancelOrder.this , AdminViewOrders.class);
                startActivity(intent);
            }
        });



    }//End


    private void getDatabase() {
        mSpiceWorldDAO = Room.databaseBuilder(this , AppDateBase.class , AppDateBase.DATABASE_NAME)
                .allowMainThreadQueries()
                .build()
                .SpiceWorldDAO();
    }



}