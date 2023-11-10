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
import com.example.spiceworld.Variables.AddSpiceByUser;
import com.example.spiceworld.Variables.FeedBack;
import com.example.spiceworld.Variables.Payment;
import com.example.spiceworld.Variables.ShippinAddress;
import com.example.spiceworld.Variables.Spice;
import com.example.spiceworld.databinding.ActivityAdminViewOrdersBinding;

import java.util.List;

public class AdminViewOrders extends AppCompatActivity {

    ActivityAdminViewOrdersBinding binding;
    private TextView viewSpice, vPayment , vAddress , vFeedback;
    private Button backBtn;
    private SpiceWorldDAO mSpiceWorldDAO;

    private List<AddSpiceByUser> mAddSpiceByUserList;
    private List<Payment> mPaymentList;
    private List <FeedBack> mFeedBackList;
    private List<ShippinAddress> mShippinAddressList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view_orders);

        getDatabase();
        binding = ActivityAdminViewOrdersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewSpice = binding.textView7AdminViewOrder;
        vPayment = binding.textView8AdminViewOrder;
        vAddress = binding.textView9AdminViewOrder;
        vFeedback =binding.textView10AdminViewOrder;
        backBtn = binding.button4AdminViewOrder;

        viewSpice.setMovementMethod(new ScrollingMovementMethod());
        vPayment.setMovementMethod(new ScrollingMovementMethod());
        vFeedback.setMovementMethod(new ScrollingMovementMethod());
        vAddress.setMovementMethod(new ScrollingMovementMethod());

        refreshDisplay();
        refreshDisplay2();
        refreshDisplay3();
        refreshDisplay1();



        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminViewOrders.this , Admin.class);
                startActivity(intent);
            }
        });

    }//End]


    private void refreshDisplay(){

        mAddSpiceByUserList = mSpiceWorldDAO.getAllAddSpiceByUser();
        if(!mAddSpiceByUserList.isEmpty()){
            StringBuilder sb = new StringBuilder();
            for(AddSpiceByUser spice: mAddSpiceByUserList){
                sb.append(spice.toString());
            }
            viewSpice.setText((sb.toString()));

        }
        else {
            viewSpice.setText("No order yet to cook");

        }

    }
    private void refreshDisplay2(){

        mPaymentList = mSpiceWorldDAO.getAllPayment();
        if(!mPaymentList.isEmpty()){
            StringBuilder sb = new StringBuilder();
            for(Payment spice: mPaymentList){
                sb.append(spice.toString());
            }
            vPayment.setText((sb.toString()));

        }
        else {
            vPayment.setText("No payment yet to cook");

        }

    }
    private void refreshDisplay3(){

        mShippinAddressList = mSpiceWorldDAO.getAllShippingAdd();
        if(!mShippinAddressList.isEmpty()){
            StringBuilder sb = new StringBuilder();
            for(ShippinAddress spice: mShippinAddressList){
                sb.append(spice.toString());
            }
            vAddress.setText((sb.toString()));

        }
        else {
            vAddress.setText("No Shippment address yet to cook");

        }

    }


    private void refreshDisplay1(){

        mFeedBackList = mSpiceWorldDAO.getAllFeedBacks();
        if(!mFeedBackList.isEmpty()){
            StringBuilder sb = new StringBuilder();
            for(FeedBack spice: mFeedBackList){
                sb.append(spice.toString());
            }
            vFeedback.setText((sb.toString()));

        }
        else {
            vFeedback.setText("No feedback");

        }

    }
    private void getDatabase() {
        mSpiceWorldDAO = Room.databaseBuilder(this , AppDateBase.class , AppDateBase.DATABASE_NAME)
                .allowMainThreadQueries()
                .build()
                .SpiceWorldDAO();
    }
}