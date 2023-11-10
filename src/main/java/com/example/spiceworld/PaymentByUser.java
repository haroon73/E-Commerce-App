package com.example.spiceworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.spiceworld.DB.AppDateBase;
import com.example.spiceworld.DB.SpiceWorldDAO;
import com.example.spiceworld.Variables.AddSpiceByUser;
import com.example.spiceworld.Variables.Payment;
import com.example.spiceworld.Variables.Spice;
import com.example.spiceworld.Variables.User;
import com.example.spiceworld.databinding.ActivityPaymentByUserBinding;

import java.util.List;

public class PaymentByUser extends AppCompatActivity {
    ActivityPaymentByUserBinding binding;

    private EditText cardInfo , dateInfo , zipInfo , userinfo;
    private Button payB , ViewB;

    private SpiceWorldDAO mSpiceWorldDAO;
    private List<Payment> mPaymentList;
    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_by_user);

        binding = ActivityPaymentByUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getDatabase();
        cardInfo = binding.cardEdit;
        dateInfo = binding.dateEdit;
        zipInfo = binding.zipEdit;
        userinfo = binding.userEdit;

        payB = binding.payBtn;
        ViewB = binding.Back;

        payB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitSpice();
            }
        });

        ViewB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PaymentByUser.this , ViewPaymentByUser.class);
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
       String  cNo = cardInfo.getText().toString().trim();

       String dInfo = dateInfo.getText().toString().trim();

       String  zInfo = zipInfo.getText().toString().trim();

       String uName = userinfo.getText().toString().trim();
       Payment payment = new Payment(cNo , dInfo , zInfo , uName);

       mSpiceWorldDAO.insert(payment);


    //




}

}