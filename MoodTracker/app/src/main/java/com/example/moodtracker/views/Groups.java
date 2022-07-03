package com.example.moodtracker.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.moodtracker.R;

public class Groups extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        setTitle("Edit Groups");
    }

    public void doctor(View view) {
        Intent i = new Intent(Groups.this, edit_groups.class);
        i.putExtra("name","Doctor");
        startActivity(i);
    }

    public void family(View view) {
        Intent i = new Intent(Groups.this, edit_groups.class);
        i.putExtra("name","Family");
        startActivity(i);
    }

    public void close_friends(View view) {
        Intent i = new Intent(Groups.this, edit_groups.class);
        i.putExtra("name","Close Friends");
        startActivity(i);
    }

    public void friends(View view) {
        Intent i = new Intent(Groups.this, edit_groups.class);
        i.putExtra("name","Friends");
        startActivity(i);
    }
}