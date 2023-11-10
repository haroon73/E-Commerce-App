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
import com.example.spiceworld.databinding.ActivityUpdateCartBinding;

public class UpdateCart extends AppCompatActivity {

    ActivityUpdateCartBinding binding;
    private EditText spiceName , newSPiceName;

    private Button updateBtn , backbtn;

    private SpiceWorldDAO mSpiceWorldDAO;


    private AddSpiceByUser mAddSpiceByUser;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_cart);

        binding = ActivityUpdateCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        spiceName = binding.eidtSpice;
        newSPiceName = binding.eidtspice2;
        updateBtn = binding.updteBtn;
        backbtn = binding.backBtn;

        getDatabase();

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String spicName = spiceName.getText().toString().trim();
                String newName = newSPiceName.getText().toString().trim();

                mAddSpiceByUser = mSpiceWorldDAO.getAddSpiceByUserByName(spicName);
                mAddSpiceByUser.setAddSpiceName(newName);
                mSpiceWorldDAO.update(mAddSpiceByUser);


            }
        });

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpdateCart.this , SpiceCartActivity.class);
                startActivity(intent);
            }
        });



    }// End of onCreate








    private void getDatabase() {
        mSpiceWorldDAO = Room.databaseBuilder(this , AppDateBase.class , AppDateBase.DATABASE_NAME)
                .allowMainThreadQueries()
                .build()
                .SpiceWorldDAO();
    }
}