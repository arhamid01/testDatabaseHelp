package com.example.a71lostandfoundapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a71lostandfoundapp.data.DatabaseHelper;
import com.example.a71lostandfoundapp.model.Ad;

public class CreateAdvertActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText username, userphone, userdescription, userdate, userlocation;
    Button saveBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_advert);
        username = findViewById(R.id.userName);
        userphone = findViewById(R.id.userPhone);
        userdescription = findViewById(R.id.userDescription);
        userdate = findViewById(R.id.userDate);
        userlocation = findViewById(R.id.userLocation);
        saveBtn = findViewById(R.id.SaveBtn);
        db = new DatabaseHelper(this);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = username.getText().toString();
                String phone = userphone.getText().toString();
                String description = userdescription.getText().toString();
                String date = userdate.getText().toString();
                String location = userlocation.getText().toString();

                long result = db.insertAd(new Ad(name,phone,description,date,location));
                if (result > 0)
                {
                    Toast.makeText(CreateAdvertActivity.this, "yes", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(CreateAdvertActivity.this, "no", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}