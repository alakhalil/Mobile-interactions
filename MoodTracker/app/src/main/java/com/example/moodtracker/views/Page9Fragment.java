package com.example.moodtracker.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moodtracker.R;
import com.example.moodtracker.databinding.FragmentPage8Binding;
import com.example.moodtracker.databinding.FragmentPage9Binding;

import java.util.ArrayList;

public class Page9Fragment extends Fragment {
    private FragmentPage9Binding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentPage9Binding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ArrayList<RV> arrayList = new ArrayList<RV>();
        CustomAdapter customAdapter = new CustomAdapter(getActivity(),arrayList);
        arrayList.add(new RV("Ava Nathan",R.drawable.avatar1));
        arrayList.add(new RV("Camilo Odyllo",R.drawable.avatar2));
        arrayList.add(new RV("Derek Mac",R.drawable.avatar3));
        arrayList.add(new RV("Jack Uke",R.drawable.avatar4));
        arrayList.add(new RV("John Doe",R.drawable.avatar5));
        arrayList.add(new RV("Haifa Nato",R.drawable.avatar6));
        arrayList.add(new RV("Layla Florian",R.drawable.avatar7));
        arrayList.add(new RV("Liah Kaylee",R.drawable.avatar8));
        binding.recycler.setAdapter(customAdapter);


        return root;
    }
}