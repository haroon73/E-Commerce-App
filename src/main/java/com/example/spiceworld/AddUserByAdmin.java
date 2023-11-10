package com.example.spiceworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddUserByAdmin extends AppCompatActivity {

    private TextView addUserView1;

    private Button addUserBtn1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user_by_admin);

        addUserView1 = findViewById(R.id.AddUserByAdminV1);

        addUserBtn1 = findViewById(R.id.AddUserByAdminBtn1);


        addUserBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddUserByAdmin.this , Admin.class);
                startActivity(intent);
            }
        });

    }
}