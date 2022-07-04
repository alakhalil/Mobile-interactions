package com.example.moodtracker.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.moodtracker.R;

public class page12 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page12);
        setTitle("Connections");
    }

    public void pending_requests(View view) {
        Intent i = new Intent(page12.this, page13.class);
        startActivity(i);
    }
}