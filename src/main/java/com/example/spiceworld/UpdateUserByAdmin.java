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
import com.example.spiceworld.Variables.User;

public class UpdateUserByAdmin extends AppCompatActivity {

    private TextView addUserView1;

    private EditText oldName , uneName;

    private Button backBtn ,  updateuser;
    private SpiceWorldDAO mSpiceWorldDAO;

    private User mUser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user_by_admin);

        addUserView1 = findViewById(R.id.AddUserByAdminV1);

        oldName = findViewById(R.id.oldEdit);
        uneName = findViewById(R.id.newEdit);
        updateuser = findViewById(R.id.updatebtn);
        backBtn = findViewById(R.id.AddUserByAdminBtn1);
      getDatabase();
        // button to update user

        updateuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oldN = oldName.getText().toString().trim();
                String newN = uneName.getText().toString().trim();
                mUser = mSpiceWorldDAO.getUserByUserName(oldN);
                mUser.setUserName(newN);
                mSpiceWorldDAO.update(mUser);

            }
        });


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpdateUserByAdmin.this , ViewUserByAdmin.class);
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