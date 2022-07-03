package com.example.moodtracker.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import com.example.moodtracker.R;

public class Contact_details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);
        String name = getIntent().getStringExtra("namee");
        TextView textView = findViewById(R.id.textView11);
        TextView textView2 = findViewById(R.id.textView15);
        textView.setText(name);
        textView2.setText(name+"@gmail.com");




    }
}