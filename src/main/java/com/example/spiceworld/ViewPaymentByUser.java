package com.example.spiceworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.spiceworld.DB.AppDateBase;
import com.example.spiceworld.DB.SpiceWorldDAO;
import com.example.spiceworld.Variables.Payment;
import com.example.spiceworld.Variables.User;
import com.example.spiceworld.databinding.ActivityViewPaymentByUserBinding;

import java.util.List;

public class ViewPaymentByUser extends AppCompatActivity {

    ActivityViewPaymentByUserBinding binding;

    private TextView viewInfo;
    private Button back;


    private SpiceWorldDAO mSpiceWorldDAO;
    private List<Payment> mPaymentList;

   private Payment mPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_payment_by_user);
        getDatabase();

        binding = ActivityViewPaymentByUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewInfo = binding.payView;
        back = binding.backBtn;
        showUser();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewPaymentByUser.this , UserActivity.class);
                startActivity(intent);
            }
        });


    }//End of onCreate

    private void showUser() {


        mPaymentList = mSpiceWorldDAO.getAllPayment();

        if(!mPaymentList.isEmpty()){
            StringBuilder sb = new StringBuilder();
            for(Payment user: mPaymentList){
                sb.append(user.toString());
            }
            viewInfo.setText((sb.toString()));

        }
        else {
            viewInfo.setText("No payment info");

        }
    }

    private void getDatabase() {
        mSpiceWorldDAO = Room.databaseBuilder(this , AppDateBase.class , AppDateBase.DATABASE_NAME)
                .allowMainThreadQueries()
                .build()
                .SpiceWorldDAO();
    }
}