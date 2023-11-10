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
import com.example.spiceworld.databinding.ActivityRemoveSpiceByAdminBinding;

public class RemoveSpiceByAdmin extends AppCompatActivity {

    ActivityRemoveSpiceByAdminBinding binding;

    private EditText spiceName;

    private Button removeSpiceBtn , backAdminBtn;

    private SpiceWorldDAO mSpiceWorldDAO;
    private Spice mSpice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_spice_by_admin);

        binding =ActivityRemoveSpiceByAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        spiceName = binding.EidtSpice;

        removeSpiceBtn = binding.removeBtn;
        backAdminBtn = binding.backBtn;

        getDatabase();

        // Button to remove

        removeSpiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = spiceName.getText().toString().trim();

                mSpice = mSpiceWorldDAO.getSpiceBySpiceName(name);

                mSpiceWorldDAO.delete(mSpice);

            }
        });


        // Button back to admin
        backAdminBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RemoveSpiceByAdmin.this , Admin.class);
                startActivity(intent);
            }
        });

    }

    private void getDatabase() {
        mSpiceWorldDAO = Room.databaseBuilder(this , AppDateBase.class , AppDateBase.DATABASE_NAME)
                .allowMainThreadQueries()
                .build()
                .SpiceWorldDAO();
    }


}