package com.example.moodtracker.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.moodtracker.R;

public class page10 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page10);
        setTitle("Contat");
        String name = getIntent().getStringExtra("namee");
        int photo = getIntent().getIntExtra("photoo",0);
        ImageView imageView = findViewById(R.id.imageView2);
        imageView.setImageResource(photo);
        TextView textView = findViewById(R.id.textView11);
        TextView textView2 = findViewById(R.id.textView15);
        textView.setText(name);
        textView2.setText(name.toLowerCase().replace(" ", ".")+"@gmail.com");
    }
}