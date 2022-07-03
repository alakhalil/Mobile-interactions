package com.example.moodtracker.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.moodtracker.R;

public class Connections extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connections);
        setTitle("Connections");
    }

    public void pending_requests(View view) {
        Intent i = new Intent(Connections.this,Pending.class);
        startActivity(i);
    }
}