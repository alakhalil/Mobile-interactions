package com.example.moodtracker.views;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.moodtracker.R;

public class ContactDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.more_contact_details);
        setTitle("Contact");
        String name = getIntent().getStringExtra("namee");
        int photo = getIntent().getIntExtra("photoo",0);
        ImageView imageView = findViewById(R.id.imageView2);
        imageView.setImageResource(photo);
        TextView textView = findViewById(R.id.textView11);
        TextView textView2 = findViewById(R.id.textView15);
        textView.setText(name);
        textView2.setText(name.toLowerCase().replace(" ", ".")+"@gmail.com");
    }

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);

        TextView textView = new TextView(this);
        textView.setText(title);
        textView.setTextColor(Color.WHITE);
        textView.setTextSize(20.0f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        textView.setGravity(Gravity.CENTER_HORIZONTAL);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(textView);
    }
}