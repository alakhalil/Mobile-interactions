package com.example.moodtracker.views;

import androidx.appcompat.app.AppCompatActivity;
import com.example.moodtracker.R;

import android.os.Bundle;

public class Pending extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending);
        setTitle("Pending Requests");
    }
}