package com.example.spiceworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spiceworld.DB.AppDateBase;
import com.example.spiceworld.DB.SpiceWorldDAO;
import com.example.spiceworld.Variables.Spice;
import com.example.spiceworld.Variables.User;
import com.example.spiceworld.databinding.ActivityAddSpiceByAdminBinding;

import java.util.List;

public class AddSpiceByAdmin extends AppCompatActivity {
    private static final String USER_ID_KEY = "com.example.spiceworld.userIdKey";
    private static final String PREFENCES_KEY = "com.example.spiceworld.PREFENCES_KEY";

     ActivityAddSpiceByAdminBinding binding;
      private TextView adminAddView , adminAddView2;

      private EditText mName , mPrice , mQuantity;

      private Button backAdminbtn , submitBtn , viewSpiceBtn;

      private SpiceWorldDAO mSpiceWorldDAO;

      private List<Spice> mSpiceList;





      User mUser;
      Spice mSpice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_spice_by_admin);

         binding = ActivityAddSpiceByAdminBinding.inflate(getLayoutInflater());
         setContentView(binding.getRoot());

        adminAddView = binding.adminAddSpiceView1;
        mName = binding.addSpiceNameByAdminEdit1;
        mPrice = binding.addSpicePriceByAdminEdit2;
        mQuantity = binding.addSpiceQuanityByAdminEdit3;
        backAdminbtn = binding.addToAdminbtn;
        submitBtn = binding.submitSpiceBtn;
        viewSpiceBtn = binding.viewSpicebtn;

        getDatabase();

        adminAddView.setMovementMethod(new ScrollingMovementMethod());

       
       submitBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
          submitSpice();
          Toast.makeText(AddSpiceByAdmin.this , "Spice is add it", Toast.LENGTH_LONG).show();
          refreshDisplay();


           }
       });

       // button
        viewSpiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           Intent intent = new Intent(AddSpiceByAdmin.this , ViewSpiceToAdmin.class);
           startActivity(intent);

            }
        });



        // Button take back to admin view

        backAdminbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddSpiceByAdmin.this , Admin.class);
                startActivity(intent);
            }
        });
    }//End of onCreate


//    // date base method
    private void getDatabase() {
        mSpiceWorldDAO = Room.databaseBuilder(this , AppDateBase.class , AppDateBase.DATABASE_NAME)
                .allowMainThreadQueries()
                .build()
                .SpiceWorldDAO();
    }

//    /// refershDispaly method
    private void refreshDisplay(){
        mSpiceList = mSpiceWorldDAO.getSpices();
        if(!mSpiceList.isEmpty()){
            StringBuilder sb = new StringBuilder();
            for(Spice spice: mSpiceList){
                sb.append(spice.toString());
            }
            adminAddView.setText((sb.toString()));
            Toast.makeText(AddSpiceByAdmin.this , "Add to date base in refershDisplay()" , Toast.LENGTH_LONG).show();
        }
        else {
            adminAddView.setText(R.string.no_cook_yet);
            Toast.makeText(AddSpiceByAdmin.this , " Not Add to date base in submitSpice()" , Toast.LENGTH_LONG).show();
        }

    }
//
//
//    // submit methdo
    private  void submitSpice(){
        String spiceName = mName.getText().toString().trim();
        double spicePrice = Double.parseDouble(mPrice.getText().toString().trim());
        int spiceQuantity = Integer.parseInt(mQuantity.getText().toString().trim());

        Spice spice = new Spice(spiceName , spicePrice , spiceQuantity , 0);
        mSpiceWorldDAO.insert(spice);

    }




}