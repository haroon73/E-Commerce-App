package com.example.spiceworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admin extends AppCompatActivity {

    private Button addSpiceBtn1 , removeSpiceBtn1 , addUserBtn1 ,
            removeUserBtn1 , logoutBtn , viewUserBtn ,updatebtn , discountbtn , feedB , adminCanclBtn , adminViewOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        feedB =findViewById(R.id.adminFeedtBtn);

        addSpiceBtn1 = findViewById(R.id.adminAddSpiceBtn1);
        removeSpiceBtn1 = findViewById(R.id.adminRemoveSpiceBtn2);
        addUserBtn1 = findViewById(R.id.adminAddUserBtn4);
        removeUserBtn1 =findViewById(R.id.adminRemoveUserBtn3);
        logoutBtn = findViewById(R.id.adminBtn5);
        viewUserBtn = findViewById(R.id.adminViewUserBtn5);
        updatebtn  = findViewById(R.id.adminUpdateSpiceBtn1);
        discountbtn = findViewById(R.id.adminDiscountBtn);
        adminCanclBtn = findViewById(R.id.adminCanceltBtn);
        adminViewOrder =findViewById(R.id.adminViewOrdertBtn);

        // Button to add spices by admin
        addSpiceBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin.this , AddSpiceByAdmin.class);
                startActivity(intent);
            }
        });


        // canceloRDER BUTTON
        adminCanclBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin.this , AdminCancelOrder.class);
                startActivity(intent);
            }
        });

        // view order button
        adminViewOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin.this , AdminViewOrders.class);
                startActivity(intent);
            }
        });





        // Button to remove spices by admin
        removeSpiceBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin.this , RemoveSpiceByAdmin.class);
                startActivity(intent);
            }
        });

        // button to feedback
        feedB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin.this , viewFeedBackByAdmin.class);
                startActivity(intent);
            }
        });

        // discount buuton
        discountbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin.this , DiscountByAdmin.class);
                startActivity(intent);
            }
        });

        //Button to add user by admin
        addUserBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin.this , UpdateUserByAdmin.class);
                startActivity(intent);
            }
        });


        // Button to remove user by admin

        removeUserBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin.this , RemoveUser.class);
                startActivity(intent);
            }
        });

        // update button
        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin.this , UpdateSpiceNameByAdmin.class);
                startActivity(intent);
            }
        });


        // Button to view users
        viewUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin.this , ViewUserByAdmin.class);
                startActivity(intent);
            }
        });

        // Button to logout as admin

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin.this , LoginActivity.class);
                startActivity(intent);
            }
        });


    }
}