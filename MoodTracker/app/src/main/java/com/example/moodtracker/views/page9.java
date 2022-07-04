package com.example.moodtracker.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import com.example.moodtracker.R;

import java.util.ArrayList;

public class page9 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Members");
        setContentView(R.layout.activity_more24);
        RecyclerView recyclerView = findViewById(R.id.recycler);
        ArrayList<RV> arrayList = new ArrayList<RV>();
        CustomAdapter customAdapter = new CustomAdapter(this,arrayList);
        arrayList.add(new RV("Ava Nathan",R.drawable.avatar1));
        arrayList.add(new RV("Camilo Odyllo",R.drawable.avatar2));
        arrayList.add(new RV("Derek Mac",R.drawable.avatar3));
        arrayList.add(new RV("Jack Uke",R.drawable.avatar4));
        arrayList.add(new RV("John Doe",R.drawable.avatar5));
        arrayList.add(new RV("Haifa Nato",R.drawable.avatar6));
        arrayList.add(new RV("Layla Florian",R.drawable.avatar7));
        arrayList.add(new RV("Liah Kaylee",R.drawable.avatar8));
        recyclerView.setAdapter(customAdapter);
    }
}