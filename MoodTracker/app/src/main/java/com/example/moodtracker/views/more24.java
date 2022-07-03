package com.example.moodtracker.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import com.example.moodtracker.R;

import java.util.ArrayList;

public class more24 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more24);
        RecyclerView recyclerView = findViewById(R.id.recycler);
        ArrayList<RV> arrayList = new ArrayList<RV>();
        CustomAdapter customAdapter = new CustomAdapter(this,arrayList);
        arrayList.add(new RV("ava_nathan"));
        arrayList.add(new RV("jack_uke"));
        arrayList.add(new RV("camilo_odyllo"));
        arrayList.add(new RV("ava_nathan"));
        arrayList.add(new RV("layla_florian"));
        arrayList.add(new RV("liah_kaylee"));
        arrayList.add(new RV("derek_mac"));
        arrayList.add(new RV("haifa_nato"));
        recyclerView.setAdapter(customAdapter);
    }
}