package com.example.moodtracker.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.moodtracker.R;

public class page7 extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page7);
        setTitle("Edit Groups");
        button = findViewById(R.id.other);
        Button button1 = findViewById(R.id.new_group);
        LinearLayout layout = findViewById(R.id.linear_);
        EditText editText = findViewById(R.id.edit_new);
        Button button2 = findViewById(R.id.add_new);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout.setVisibility(View.VISIBLE);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String name =  editText.getText().toString();
              button1.setVisibility(View.VISIBLE);
              button.setText(name);
              button.setCompoundDrawablesWithIntrinsicBounds(R.drawable.help_circle, 0, R.drawable.chevron_right, 0);
                layout.setVisibility(View.INVISIBLE);
            }
        });
      //  layout.setVisibility(View.VISIBLE);
    }

    public void doctor(View view) {
        Intent i = new Intent(page7.this, page8.class);
        i.putExtra("name","Doctor");
        startActivity(i);
    }

    public void family(View view) {
        Intent i = new Intent(page7.this, page8.class);
        i.putExtra("name","Family");
        startActivity(i);
    }

    public void close_friends(View view) {
        Intent i = new Intent(page7.this, page8.class);
        i.putExtra("name","Close Friends");
        startActivity(i);
    }

    public void friends(View view) {
        Intent i = new Intent(page7.this, page8.class);
        i.putExtra("name","Friends");
        startActivity(i);
    }
}