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
import com.example.spiceworld.databinding.ActivityUpdateSpiceNameByAdminBinding;

public class UpdateSpiceNameByAdmin extends AppCompatActivity {

    ActivityUpdateSpiceNameByAdminBinding binding;

    private EditText oldName , newName;
    private Button updateBtn , backBtn;

    private SpiceWorldDAO mSpiceWorldDAO;
    private Spice mSpice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_spice_name_by_admin);

        binding = ActivityUpdateSpiceNameByAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        oldName = binding.spiceEdit1;
        newName = binding.editspice2;

        updateBtn= binding.Updatebtn;
        backBtn =binding.Updatebtn1;
        getDatabase();


        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oName = oldName.getText().toString().trim();
                String nName = newName.getText().toString().trim();
                mSpice = mSpiceWorldDAO.getSpiceBySpiceName(oName);
                mSpice.setSpiceName(nName);
                mSpiceWorldDAO.update(mSpice);

            }
        });

        // back buttom
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpdateSpiceNameByAdmin.this , ViewSpiceToAdmin.class);
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
}