package com.example.spiceworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.spiceworld.DB.AppDateBase;
import com.example.spiceworld.DB.SpiceWorldDAO;
import com.example.spiceworld.Variables.AddSpiceByUser;
import com.example.spiceworld.Variables.FeedBack;
import com.example.spiceworld.Variables.Payment;
import com.example.spiceworld.Variables.ShippinAddress;

public class CancelSpiceActivity extends AppCompatActivity {

      private TextView cancelView1;
      private EditText userName;

      private Button backCancelbtn , cncelBtn;

      private SpiceWorldDAO mSpiceWorldDAO;

      private AddSpiceByUser mAddSpiceByUser;
      private Payment mPayment;
      private FeedBack mFeedBack;
      private ShippinAddress mShippinAddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel_spice);

        cancelView1 = findViewById(R.id.cancelSpiceView1);

       userName = findViewById(R.id.spiceNameEdit);

        backCancelbtn = findViewById(R.id.backToUserCancelBtn);
        cncelBtn = findViewById(R.id.submitCancelBtn);
        getDatabase();

        cncelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = userName.getText().toString().trim();
                mAddSpiceByUser = mSpiceWorldDAO.getAddSpiceByUserName(name);
                mPayment = mSpiceWorldDAO.getPaymentByUserName(name);
                mFeedBack = mSpiceWorldDAO.getFeedByUserName(name);
                mShippinAddress = mSpiceWorldDAO.getShipByUserName(name);

                mSpiceWorldDAO.delete(mAddSpiceByUser);
                mSpiceWorldDAO.delete(mPayment);
                mSpiceWorldDAO.delete(mFeedBack);
                mSpiceWorldDAO.delete(mShippinAddress);

            }
        });

        backCancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CancelSpiceActivity.this , UserActivity.class);
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
}