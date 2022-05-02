package com.example.a71lostandfoundapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button createBtn, showBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createBtn = findViewById(R.id.createAdBtn);
        showBtn = findViewById(R.id.showItemsBtn);
        Intent intent = new Intent(this,CreateAdvertActivity.class);
        Intent intent2 = new Intent(this,ShowItemsActivity.class);

        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent2);
            }
        });

    }
}